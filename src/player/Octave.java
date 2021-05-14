package player;

// Represents an octave.
public class Octave {
	
	// Constants
	public static final int defaultOctave = 5;
	public static final int maxOctave = 9;
	public static final int minOctave = 0;

	// Attribute for current octave
	private int octave;

	// Argument constructor
	public Octave(int octave) {
		this.octave = octave;
	}

	// Default constructor
	public Octave() {
		this.octave = defaultOctave;
	}

	// Setter
	public void setOctave(int newOctave) {
		octave = newOctave;
		if (octave > maxOctave)
			octave = maxOctave;
		else if (octave < minOctave)
			octave = minOctave;
	}
	
	// Getter
	public int getOctave() {
		return octave;
	}
}
