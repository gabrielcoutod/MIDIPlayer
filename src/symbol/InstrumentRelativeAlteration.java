package symbol;

import player.TCPlayer;

// Symbol from input text that represents the instrument change.
public class InstrumentRelativeAlteration extends Symbol {
	private int difference;

	public InstrumentRelativeAlteration(int difference) {
		this.difference = difference;
	}

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
		InstrumentRelativeAlteration other = (InstrumentRelativeAlteration) obj;
		if (difference != other.difference)
			return false;
		return true;
	}

	public void alterPlayer(TCPlayer player) {
		player.setInstrument(player.getInstrument() + difference);
	}
}