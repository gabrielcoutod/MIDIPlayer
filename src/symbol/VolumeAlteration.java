package symbol;

import player.TCPlayer;

//Symbol from input text that represents a volume change.
public class VolumeAlteration extends Symbol {
	
	// Constants
	public static final int positiveAlteration = 10;
	public static final int negativeAlteration = -10;
	
	// Attribute for the alteration
	private int difference;

	// Argument constructor
	public VolumeAlteration(int value) {
		this.difference = value;
	}

	// Getter
	public int getDifference() {
		return difference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + difference;
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
		VolumeAlteration other = (VolumeAlteration) obj;
		if (difference != other.difference)
			return false;
		return true;
	}

	// Alteration
	public void alterPlayer(TCPlayer player) {
		player.setVolume(player.getVolume() + difference);
	}

}
