package player;

//Represents a BPM.
public class BPM {
	public static final int defaultBPM = 120;
	public static final int maxBPM = 220;
	public static final int minBPM = 40;

	private int bpm;

	public BPM(int bpm) {
		this.bpm = bpm;
	}

	public BPM() {
		this.bpm = defaultBPM;
	}

	public void setBPM(int newBPM) {
		bpm = newBPM;
		if (bpm > maxBPM)
			bpm = maxBPM;
		else if (bpm < minBPM)
			bpm = minBPM;
	}

	public int getBPM() {
		return bpm;
	}
}
