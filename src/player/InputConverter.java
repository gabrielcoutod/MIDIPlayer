package player;

import symbol.Note;
import symbol.Notes;
import symbol.OctaveAlteration;
import symbol.BPMAlteration;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;
import symbol.InstrumentAlteration;
import symbol.InstrumentRelativeAlteration;
import symbol.Symbol;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

//Class for converting from text input to Symbols.
public class InputConverter {

	// Constants
	public static char aNote = 'A';
	public static char cNote = 'C';
	public static char dNote = 'D';
	public static char eNote = 'E';
	public static char fNote = 'F';
	public static char gNote = 'G';
	public static char pause = 'P';
	public static char randomNote = 'R';
	public static char positiveVolumeAlteration = '+';
	public static char negativeVolumeAlteration = '-';
	public static char volumeDoubleAlteration = ' ';
	public static char agogo = '!';
	public static char tubularBells = '\n';
	public static char panFlute = ';';
	public static char churchOrgan = ',';
	public static ArrayList<Character> hapsichord = new ArrayList<Character>(Arrays.asList('i','o','u'));
	public static String BPMpositiveAlteration = "BPM+";
	public static String BPMnegativeAlteration = "BPM-";
	public static char bSymbol = 'B';
	public static char octaveChar= 'T';
	public static char octavePositiveChar = '+';
	public static char octaveNegativeChar = '-';
	public static String octaveAlteration = "T+";
	public static ArrayList<Character> octaveIncrementAlteration =  new ArrayList<Character>(Arrays.asList('.','?'));
	
	
	// The convert function takes text as input and returns a Symbol array that
	// contains the sequence of symbols for the player class to read. It uses a
	// sequence of if statements to relate to the visual representation of a
	// decision tree structure, which is the solution adopted by this class to
	// convert the input into a Symbol array. Since we don't know the input size
	// (therefore we don't know the output size either), we use the ArrayList class,
	// which allows us to replicate the behavior of a dynamically sized array.
	public static Symbol[] convert(String text_in) {
		ArrayList<Symbol> result = new ArrayList<Symbol>();
		int length = text_in.length();
		int index = 0;
		while (index < length) {
			if (text_in.charAt(index) == aNote) {
				result.add(new Note(Notes.A));
			} else if (text_in.charAt(index) == bSymbol) {
				// Checks if has enough symbols to represent a BPM alteration, if so checks if it is a BPM alteration
				if (length - index >= BPMnegativeAlteration.length()) {
					if (text_in.substring(index, index + 4).equals(BPMpositiveAlteration)) {
						result.add(new BPMAlteration(BPMAlteration.positiveAlteration));
						index = index + 3;
					} else if (text_in.substring(index, index + 4).equals(BPMnegativeAlteration)) {
						result.add(new BPMAlteration(BPMAlteration.negativeAlteration));
						index = index + 3;
					} else {// B note
						result.add(new Note(Notes.B));
					}
				} else { // B note
					result.add(new Note(Notes.B));
				}
			} else if (text_in.charAt(index) == cNote) {
				result.add(new Note(Notes.C));
			} else if (text_in.charAt(index) == dNote) {
				result.add(new Note(Notes.D));
			} else if (text_in.charAt(index) == eNote) {
				result.add(new Note(Notes.E));
			} else if (text_in.charAt(index) == fNote) {
				result.add(new Note(Notes.F));
			} else if (text_in.charAt(index) == gNote) {
				result.add(new Note(Notes.G));
			} else if (text_in.charAt(index) == pause) {
				result.add(new Note(Notes.P));
			} else if (text_in.charAt(index) == randomNote) {
				List<Note> musicalNotes = Note.getMusicalNotes();
				result.add(musicalNotes.get(new Random().nextInt(musicalNotes.size())));
			} else if (text_in.charAt(index) == positiveVolumeAlteration) {
				result.add(new VolumeAlteration(VolumeAlteration.positiveAlteration));
			} else if (text_in.charAt(index) == negativeVolumeAlteration) {
				result.add(new VolumeAlteration(VolumeAlteration.negativeAlteration));
			} else if (text_in.charAt(index) == volumeDoubleAlteration) {
				result.add(new VolumeDoubleAlteration());
			} else if (text_in.charAt(index) == octaveChar) {
				// Checks if + or - exists after the letter
				if (length - index >= octaveAlteration.length()) {
					if (text_in.charAt(index + 1) == octavePositiveChar) {
						result.add(new symbol.OctaveAlteration(OctaveAlteration.positiveAlteration));
						index++;
					} else if (text_in.charAt(index + 1) == octaveNegativeChar) {
						result.add(new symbol.OctaveAlteration(OctaveAlteration.negativeAlteration));
						index++;
					} else { // check for previous symbol
						result.add(checkSymbolForNote(result.get(result.size()-1)));
					}
				} else { // check for previous symbol
					result.add(checkSymbolForNote(result.get(result.size()-1)));
				}
			} else if (octaveIncrementAlteration.contains(text_in.charAt(index))) {
				result.add(new symbol.OctaveIncrementAlteration());
			} else if (Character.isDigit(text_in.charAt(index))) {
				// 0-9
				result.add(new InstrumentRelativeAlteration(Character.getNumericValue(text_in.charAt(index))));
			} else if (text_in.charAt(index) == agogo) {
				result.add(new InstrumentAlteration(InstrumentAlteration.agogo));
			} else if (text_in.charAt(index) == tubularBells) {
				result.add(new InstrumentAlteration(InstrumentAlteration.tubularBells));
			} else if (text_in.charAt(index) == panFlute) {
				result.add(new InstrumentAlteration(InstrumentAlteration.panFlute));
			} else if (text_in.charAt(index) == churchOrgan) {
				result.add(new InstrumentAlteration(InstrumentAlteration.churchOrgan));
			} else if (hapsichord.contains(Character.toLowerCase(text_in.charAt(index)))) {
				result.add(new InstrumentAlteration(InstrumentAlteration.hapsichord));
			} else {
				// Else is responsible for a-g characters, any consonant that is not a note and
				// any other character.
				result.add(checkSymbolForNote(result.get(result.size()-1)));
			}
			index++;
		}
		// Converts ArrayList to array and returns the result.
		return result.toArray(new Symbol[result.size()]);
	}
	
	// checks if symbol is a Note, and repeats it if it is the case
	// if it isn't a note returns Pause
	private static Symbol checkSymbolForNote(Symbol symbol){
		if (Note.getMusicalNotes().contains(symbol))
			return symbol;
		else
			return new Note(Notes.P);
	}
}
