package symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Enum for possible Notes.
//P is a pause.
public enum Notes {
	
	// Notes
	A, B, C, D, E, F, G, P;
	// Possible musical notes
	private static ArrayList<Notes> musicalNotes;

	// Static initializer for musicalNotes
	static {
		musicalNotes = new ArrayList<Notes>(Arrays.asList(Notes.values()));
		musicalNotes.remove(Notes.P);
	}

	// Getter for musicalNotes
	public static List<Notes> getMusicalNotes() {
		return musicalNotes;
	}
}
