package symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Possible Notes.
//P is a pause.
public enum Notes {
	A, B, C, D, E, F, G, P;

	private static ArrayList<Notes> musicalNotes;

	static {
		musicalNotes = new ArrayList<Notes>(Arrays.asList(Notes.values()));
		musicalNotes.remove(Notes.P);
	}

	public static List<Notes> getMusicalNotes() {
		return musicalNotes;
	}
}
