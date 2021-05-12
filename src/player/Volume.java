package player;

//Represents a volume.
public class Volume {
	public static final int defaultVolume = 127;
	public static final int maxVolume = 127;
	public static final int minVolume = 2;

	private int volume;

	public Volume(int volume) {
		this.volume = volume;
	}

	public Volume() {
		this.volume = defaultVolume;
	}

	public void setVolume(int newVolume) {
		volume = newVolume;
		if (volume > maxVolume)
			volume = maxVolume;
		else if (volume < minVolume)
			volume = minVolume;
	}

	public int getVolume() {
		return volume;
	}
}
