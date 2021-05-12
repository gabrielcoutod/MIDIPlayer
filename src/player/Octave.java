package player;
//Represents an octave.
public class Octave {
	public static final int defaultOctave = 5;
	public static final int maxOctave = 10;
	public static final int minOctave = 0;

	private int octave;

	public Octave(int octave) {
		this.octave = octave;
	}

	public Octave() {
		this.octave = defaultOctave;
	}

	public int getOctave() {
		return octave;
	}

	public void setOctave(int newOctave) {
		octave = newOctave;
		if (octave > maxOctave)
			octave = maxOctave;
		else if (octave < minOctave)
			octave = minOctave;
	}
}
