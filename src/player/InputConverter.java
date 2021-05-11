package player;

import symbol.Note;
import symbol.Notes;
import symbol.BPMAlteration;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;
import symbol.InstrumentAlteration;
import symbol.InstrumentRelativeAlteration;
import symbol.Symbol;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

//Class for converting from text input to Symbols.
public class InputConverter {

	/*
		The convert function takes text as input and returns a Symbol array that contains the sequence of symbols
		for the player class to read.
		It uses a sequence of if statements to relate to the visual representation of a decision tree structure,
		which is the solution adopted by this class to convert the input into a Symbol array.
		Since we don't know the input size (therefore we don't know the output size either), we use the ArrayList
		class, which allows us to replicate the behavior of a dynamically sized array.
		The method trims the input down until it has 0 length, at this point, it returns the result.
	 */
    public static Symbol[] convert(String text_in) {
		ArrayList<Symbol> result = new ArrayList<Symbol>();
    	while (text_in.length() > 0) {
			int index = 0;
			if (text_in.charAt(0) == 'A') {
				result.add(new Note(Notes.A));
				index++;
			} else if (text_in.charAt(0) == 'B') {
				// Verifica se é BPM+ ou BPM-
				if (text_in.length() >= "BPM+".length()) {
					if (text_in.substring(index, index + 4).equals("BPM+")) {
						result.add(new BPMAlteration(50));
						index = index + 4;
					} else if (text_in.substring(index, index + 4).equals("BPM-")) {
						result.add(new BPMAlteration(-50));
						index = index + 4;
					} else {
						result.add(new Note(Notes.B));
						index++;
					}
				} else {
					result.add(new Note(Notes.B));
					index++;
				}
			} else if (text_in.charAt(0) == 'C') {
				result.add(new Note(Notes.C));
				index++;
			} else if (text_in.charAt(0) == 'D') {
				result.add(new Note(Notes.D));
				index++;
			} else if (text_in.charAt(0) == 'E') {
				result.add(new Note(Notes.E));
				index++;
			} else if (text_in.charAt(0) == 'F') {
				result.add(new Note(Notes.F));
				index++;
			} else if (text_in.charAt(0) == 'G') {
				result.add(new Note(Notes.G));
				index++;				
			} else if (text_in.charAt(0) == 'P') {
				result.add(new Note(Notes.P));
				index++;
			} else if (text_in.charAt(0) == 'R') {
				List<Note> musicalNotes = Note.getMusicalNotes();
				result.add(musicalNotes.get(new Random().nextInt(musicalNotes.size())));
				index++;
			} else if (text_in.charAt(0) == '+') {
				result.add(new VolumeAlteration(10));
				index++;
			} else if (text_in.charAt(0) == '-') {
				result.add(new VolumeAlteration(-10));
				index++;
			} else if (text_in.charAt(0) == ' ') {
				result.add(new VolumeDoubleAlteration());
				index++;
			} else if (text_in.charAt(0) == 'T') {
				// Checks if + or - exists after the letter
				if (text_in.length() >= "T+".length()) {
					if (text_in.charAt(1) == '+') {
						result.add(new symbol.OctaveAlteration(1));
						index = index + 2;
					} else if (text_in.charAt(1) == '-') {
						result.add(new symbol.OctaveAlteration(-1));
						index += 2;
					} else {
						if (Note.getMusicalNotes().contains(result.get(result.size()-1)))
							result.add(result.get(result.size()-1));
						else
							result.add(new Note(Notes.P));
						index++;
					}
				} else {
					if (Note.getMusicalNotes().contains(result.get(result.size()-1)))
						result.add(result.get(result.size()-1));
					else
						result.add(new Note(Notes.P));
					index++;
				}
			} else if (text_in.charAt(0) == '.' || text_in.charAt(0) == '?') {
				result.add(new symbol.OctaveIncrementAlteration());
				index++;
			} else if (Character.isDigit(text_in.charAt(0))) {
				// 0-9
				result.add(new InstrumentRelativeAlteration(Character.getNumericValue(text_in.charAt(0))));
				index++;
			} else if (text_in.charAt(0) == '!') {
				result.add(new InstrumentAlteration(114));
				index++;
			} else if (text_in.charAt(0) == '\n') {
				result.add(new InstrumentAlteration(15));
				index++;
			} else if (text_in.charAt(0) == ';') {
				result.add(new InstrumentAlteration(76));
				index++;
			} else if (text_in.charAt(0) == ',') {
				result.add(new InstrumentAlteration(20));
				index++;
			} else if (Character.toLowerCase(text_in.charAt(0)) == 'i' || Character.toLowerCase(text_in.charAt(0)) == 'o' || Character.toLowerCase(text_in.charAt(0)) == 'u') {
				// I O U vowels
				result.add(new InstrumentAlteration(7));
				index++;
			} else {
				// Else is responsible for a-g characters, any consonant that is not a note and any other character.
				if (Note.getMusicalNotes().contains(result.get(result.size()-1)))
					result.add(result.get(result.size()-1));
				else
					result.add(new Note(Notes.P));
				index++;
			}
			text_in = text_in.substring(index);
        }
    	// Coverts ArrayList to array and returns the result.
    	return result.toArray(new Symbol[result.size()]);
    }
}

