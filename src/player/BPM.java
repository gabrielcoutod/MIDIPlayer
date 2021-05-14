package player;

//Represents a BPM.
public class BPM {
	
	// Constants
	public static final int defaultBPM = 120;
	public static final int maxBPM = 400;
	public static final int minBPM = 40;

	// Attribute for current BPM
	private int bpm;

	// Argument constructor
	public BPM(int bpm) {
		this.bpm = bpm;
	}

	// Default constructor
	public BPM() {
		this.bpm = defaultBPM;
	}

	// Setter
	public void setBPM(int newBPM) {
		bpm = newBPM;
		if (bpm > maxBPM)
			bpm = maxBPM;
		else if (bpm < minBPM)
			bpm = minBPM;
	}

	// Getter
	public int getBPM() {
		return bpm;
	}
}
