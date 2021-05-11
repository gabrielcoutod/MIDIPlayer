package symbol;

import java.util.Arrays;
import java.util.List;

//Possible Notes.
//P is a pause.
public enum Notes {
	A, B, C, D, E, F, G, P;
	
	public static List<Notes> getMusicalNotes() {
		List<Notes> musicalNotes = Arrays.asList(Notes.values());
		musicalNotes.remove(Notes.P);
		return musicalNotes;
	}
}
