package player;

import symbol.Note;
import symbol.Notes;
import symbol.BPMAlteration;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;
import symbol.InstrumentAlteration;
import symbol.Symbol;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

//Class for converting from text input to Symbols.
public class InputConverter {
	/*
		The auto_test function checks if the result of convert() is the intended result.
		Used ONLY for testing purposes, can be deleted upon release.
	 */
	public static boolean auto_test() {
		System.out.println(Arrays.toString(convert("")));
		System.out.println(Arrays.toString(convert("BBCDEFGHAA#B#C#...")));
		System.out.println(Arrays.toString(convert("!A#B#C#D#E#F####HHguio.,;?\n op")));
		System.out.println(Arrays.toString(convert("BPM+BPN+BPM-BPN--+-+=*")));
		return true;
	}

	/*
		The check_previous function returns a Note symbol, based in the 2 previous characters.
		The functions recieves a String called sector, which is comprised of the 2 previous characters of the checked
		char and the char itself. This functions returns the previous note played if the symbol immediately before it
		is a note. In our implementation, A# is also a note, so "A#a" repeats A#.

		Disclaimer: In the specification, it is explicitly defined that the note should only be repeated if the previous
		CHARACTER is a note. This is extremely important as "A#aa" will result in two A# and a pause! This means that we
		CANNOT repeat the last symbol of the convert function's result, since doing it that way would make "A#aa" insert
		3 repetitions of the A# note. Therefore, the check_previous function is necessary.
	 */
	private static Note check_previous(String sector) {
		int sharp = sector.charAt(1) == '#' ? 1 : 0;
		switch (sector.charAt(1-sharp)) {
			case 'A':
				return sharp == 1 ? new Note(Notes.ASharp) : new Note(Notes.A);
			case 'B':
				return sharp == 1 ? new Note(Notes.C) : new Note(Notes.B);
			case 'C':
				return sharp == 1 ? new Note(Notes.CSharp) : new Note(Notes.C);
			case 'D':
				return sharp == 1 ? new Note(Notes.DSharp) : new Note(Notes.D);
			case 'E':
				return sharp == 1 ? new Note(Notes.F) : new Note(Notes.E);
			case 'F':
				return sharp == 1 ? new Note(Notes.FSharp) : new Note(Notes.F);
			case 'G':
				return sharp == 1 ? new Note(Notes.GSharp) : new Note(Notes.G);
		}
		return new Note(Notes.P);
	}

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
    	String original_text = text_in;
    	int original_index = 0;
		ArrayList<Symbol> result = new ArrayList<Symbol>();
    	while (text_in.length() > 0) {
			int index = 0;
			if (text_in.charAt(0) == 'A') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					result.add(new Note(Notes.ASharp));
					index = index + 2;
				} else {
					result.add(new Note(Notes.A));
					index++;
				}
			} else if (text_in.charAt(0) == 'B') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					// In music theory, B# = C.
					result.add(new Note(Notes.C));
					index = index + 2;
				// Verifica se é BPM+ ou BPM-
				} else if (text_in.substring(index, index + 4).equals("BPM+") || text_in.substring(index, index + 4).equals("BPM-")) {
					if (text_in.charAt(index + 3) == '+') {
						result.add(new BPMAlteration(50));
					} else if (text_in.charAt(index + 3) == '-') {
						result.add(new BPMAlteration(-50));
					}
					index = index + 4;
				} else {
					result.add(new Note(Notes.B));
					index++;
				}
			} else if (text_in.charAt(0) == 'C') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					result.add(new Note(Notes.CSharp));
					index = index + 2;
				} else {
					result.add(new Note(Notes.C));
					index++;
				}
			} else if (text_in.charAt(0) == 'D') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					result.add(new Note(Notes.DSharp));
					index = index + 2;
				} else {
					result.add(new Note(Notes.D));
					index++;
				}
			} else if (text_in.charAt(0) == 'E') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					// In music theory, E# = F.
					result.add(new Note(Notes.F));
					index = index + 2;
				} else {
					result.add(new Note(Notes.E));
					index++;
				}
			} else if (text_in.charAt(0) == 'F') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					result.add(new Note(Notes.FSharp));
					index = index + 2;
				} else {
					result.add(new Note(Notes.F));
					index++;
				}
			} else if (text_in.charAt(0) == 'G') {
				// Checks if # exists after the letter
				if (text_in.charAt(1) == '#') {
					result.add(new Note(Notes.GSharp));
					index = index + 2;
				} else {
					result.add(new Note(Notes.G));
					index++;
				}
			} else if (text_in.charAt(0) == 'P') {
				result.add(new Note(Notes.P));
				index++;
				break;
			} else if (text_in.charAt(0) == '+') {
				result.add(new VolumeAlteration(10));
				index++;
			} else if (text_in.charAt(0) == '-') {
				result.add(new VolumeAlteration(-10));
				index++;
			} else if (text_in.charAt(0) == ' ') {
				result.add(new VolumeDoubleAlteration(true));
				index++;
			} else if (text_in.charAt(0) == 'T') {
				// Checks if + or - exists after the letter
				if (text_in.charAt(1) == '+') {
					result.add(new symbol.OctaveAlteration(1));
					index = index + 2;
				} else if (text_in.charAt(1) == '-') {
					result.add(new symbol.OctaveAlteration(-1));
					index++;
				} else {
					result.add(check_previous(original_text.substring(original_index-2,original_index+1)));
					index++;
				}
			} else if (text_in.charAt(0) == '.' || text_in.charAt(0) == '?') {
				result.add(new symbol.OctaveAlteration(1));
				index++;
			} else if (Character.getNumericValue(text_in.charAt(0)) >= 0) {
				// 0-9
				result.add(new InstrumentAlteration(Character.getNumericValue(text_in.charAt(0)),true));
				index++;
			} else if (text_in.charAt(0) == '!') {
				result.add(new InstrumentAlteration(114,false));
				index++;
			} else if (text_in.charAt(0) == '\n') {
				result.add(new InstrumentAlteration(15,false));
				index++;
			} else if (text_in.charAt(0) == ';') {
				result.add(new InstrumentAlteration(76,false));
				index++;
			} else if (text_in.charAt(0) == ',') {
				result.add(new InstrumentAlteration(20,false));
				index++;
			} else if (Character.toLowerCase(text_in.charAt(0)) == 'i' || Character.toLowerCase(text_in.charAt(0)) == 'o' || Character.toLowerCase(text_in.charAt(0)) == 'u') {
				// I O U vowels
				result.add(new InstrumentAlteration(7,false));
				index++;
			} else {
				// Else is responsible for a-g characters, any consonant that is not a note and any other character.
				result.add(check_previous(original_text.substring(original_index-2,original_index+1)));
				index++;
			}
			original_index += index;
			text_in = text_in.substring(index);
        }
    	// Coverts ArrayList to array and returns the result.
    	return result.toArray(new Symbol[result.size()]);
    }
}

