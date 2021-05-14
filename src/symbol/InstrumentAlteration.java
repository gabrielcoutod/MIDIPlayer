package symbol;

import player.TCPlayer;

// Symbol from input text that represents an instrument change.
public class InstrumentAlteration extends Symbol {
	
	// Constants
	public static final int hapsichord = 6;
	public static final int agogo = 113;
	public static final int tubularBells = 14;
	public static final int panFlute = 75;
	public static final int churchOrgan = 19;
	
	// Attribute for the alteration
	private int newInstrument;

	// Argument constructor
	public InstrumentAlteration(int instrument) {
		this.newInstrument = instrument;
	}

	// Getter
	public int getInstrument() {
		return newInstrument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + newInstrument;
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
		InstrumentAlteration other = (InstrumentAlteration) obj;
		if (newInstrument != other.newInstrument)
			return false;
		return true;
	}

	// Alteration
	public void alterPlayer(TCPlayer player) {
		player.setInstrument(newInstrument);
	}
	
}