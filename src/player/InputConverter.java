package player;

import symbol.Note;
import symbol.Notes;
import symbol.BPMAlteration;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;
import symbol.InstrumentAlteration;
import symbol.InstrumentRelativeAlteration;
import symbol.Symbol;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

//Class for converting from text input to Symbols.
public class InputConverter {

	/*
	 * The convert function takes text as input and returns a Symbol array that
	 * contains the sequence of symbols for the player class to read. It uses a
	 * sequence of if statements to relate to the visual representation of a
	 * decision tree structure, which is the solution adopted by this class to
	 * convert the input into a Symbol array. Since we don't know the input size
	 * (therefore we don't know the output size either), we use the ArrayList class,
	 * which allows us to replicate the behavior of a dynamically sized array. The
	 * method trims the input down until it has 0 length, at this point, it returns
	 * the result.
	 */
	public static Symbol[] convert(String text_in) {
		ArrayList<Symbol> result = new ArrayList<Symbol>();
		int length = text_in.length();
		int index = 0;
		while (index < length) {
			if (text_in.charAt(index) == 'A') {
				result.add(new Note(Notes.A));
			} else if (text_in.charAt(index) == 'B') {
				// Verifica se � BPM+ ou BPM-
				if (length - index >= "BPM+".length()) {
					if (text_in.substring(index, index + 4).equals("BPM+")) {
						result.add(new BPMAlteration(50));
						index = index + 3;
					} else if (text_in.substring(index, index + 4).equals("BPM-")) {
						result.add(new BPMAlteration(-50));
						index = index + 3;
					} else {
						result.add(new Note(Notes.B));
					}
				} else {
					result.add(new Note(Notes.B));
				}
			} else if (text_in.charAt(index) == 'C') {
				result.add(new Note(Notes.C));
			} else if (text_in.charAt(index) == 'D') {
				result.add(new Note(Notes.D));
			} else if (text_in.charAt(index) == 'E') {
				result.add(new Note(Notes.E));
			} else if (text_in.charAt(index) == 'F') {
				result.add(new Note(Notes.F));
			} else if (text_in.charAt(index) == 'G') {
				result.add(new Note(Notes.G));
			} else if (text_in.charAt(index) == 'P') {
				result.add(new Note(Notes.P));
			} else if (text_in.charAt(index) == 'R') {
				List<Note> musicalNotes = Note.getMusicalNotes();
				result.add(musicalNotes.get(new Random().nextInt(musicalNotes.size())));
			} else if (text_in.charAt(index) == '+') {
				result.add(new VolumeAlteration(10));
			} else if (text_in.charAt(index) == '-') {
				result.add(new VolumeAlteration(-10));
			} else if (text_in.charAt(index) == ' ') {
				result.add(new VolumeDoubleAlteration());
			} else if (text_in.charAt(index) == 'T') {
				// Checks if + or - exists after the letter
				if (length - index >= "T+".length()) {
					if (text_in.charAt(index + 1) == '+') {
						result.add(new symbol.OctaveAlteration(1));
						index++;
					} else if (text_in.charAt(index + 1) == '-') {
						result.add(new symbol.OctaveAlteration(-1));
						index++;
					} else {
						if (Note.getMusicalNotes().contains(result.get(result.size() - 1)))
							result.add(result.get(result.size() - 1));
						else
							result.add(new Note(Notes.P));
					}
				} else {
					if (Note.getMusicalNotes().contains(result.get(result.size() - 1)))
						result.add(result.get(result.size() - 1));
					else
						result.add(new Note(Notes.P));
				}
			} else if (text_in.charAt(index) == '.' || text_in.charAt(index) == '?') {
				result.add(new symbol.OctaveIncrementAlteration());
			} else if (Character.isDigit(text_in.charAt(index))) {
				// 0-9
				result.add(new InstrumentRelativeAlteration(Character.getNumericValue(text_in.charAt(index))));
			} else if (text_in.charAt(index) == '!') {
				result.add(new InstrumentAlteration(113));
			} else if (text_in.charAt(index) == '\n') {
				result.add(new InstrumentAlteration(14));
			} else if (text_in.charAt(index) == ';') {
				result.add(new InstrumentAlteration(75));
			} else if (text_in.charAt(index) == ',') {
				result.add(new InstrumentAlteration(19));
			} else if (Character.toLowerCase(text_in.charAt(index)) == 'i'
					|| Character.toLowerCase(text_in.charAt(index)) == 'o'
					|| Character.toLowerCase(text_in.charAt(index)) == 'u') {
				// I O U vowels
				result.add(new InstrumentAlteration(6));
			} else {
				// Else is responsible for a-g characters, any consonant that is not a note and
				// any other character.
				if (Note.getMusicalNotes().contains(result.get(result.size() - 1)))
					result.add(result.get(result.size() - 1));
				else
					result.add(new Note(Notes.P));
			}
			index++;
		}
		// Coverts ArrayList to array and returns the result.
		return result.toArray(new Symbol[result.size()]);
	}
}
