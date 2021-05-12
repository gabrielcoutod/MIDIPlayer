package symbol;

import player.TCPlayer;

// Symbol from input text that represents the instrument change.
public class InstrumentAlteration extends Symbol {
	private int newInstrument;

	public InstrumentAlteration(int instrument) {
		this.newInstrument = instrument;
	}

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

	public void alterPlayer(TCPlayer player) {
		player.setInstrument(newInstrument);
	}
	
}