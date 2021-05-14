package player;

// Represents a volume.
public class Volume {
	
	// Constants
	public static final int defaultVolume = 32;
	public static final int maxVolume = 127;
	public static final int minVolume = 2;

	// Attribute for current volume
	private int volume;

	// Argument constructor
	public Volume(int volume) {
		this.volume = volume;
	}

	// Default constructor
	public Volume() {
		this.volume = defaultVolume;
	}

	// Setter
	public void setVolume(int newVolume) {
		volume = newVolume;
		if (volume > maxVolume)
			volume = maxVolume;
		else if (volume < minVolume)
			volume = minVolume;
	}
	
	// Getter
	public int getVolume() {
		return volume;
	}
}
