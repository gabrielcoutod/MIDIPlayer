package symbol;

import java.util.ArrayList;
import player.TCPlayer;
import org.jfugue.pattern.Pattern;

//Symbol from input text that represents a Note.
public class Note extends Symbol {
	private Notes note;
	private static ArrayList<Note> musicalNotes;

	static {
		musicalNotes = new ArrayList<Note>();
		for (Notes note : Notes.getMusicalNotes())
			musicalNotes.add(new Note(note));
	}

	public Note(Notes note) {
		this.note = note;
	}

	public Notes getNote() {
		return note;
	}

	public static ArrayList<Note> getMusicalNotes() {
		return musicalNotes;
	}

	public String toString() {
		if (note == Notes.P)
			return "C-";
		else
			return note.name();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (note != other.note)
			return false;
		return true;
	}

	public void alterPlayer(TCPlayer player) {
		Pattern updateSong = new Pattern().setTempo(player.getBPM());
        updateSong.add(":CON(7, " + player.getVolume() + ")");
        updateSong.add("I" + player.getInstrument());
        updateSong.add(toString() + player.getOctave());
        player.addToSong(updateSong);       
	}
}