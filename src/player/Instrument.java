package player;

import symbol.InstrumentAlteration;

//Represents an Instrument.
public class Instrument {
    private static final int defaultInstrument = 7;
    private static final int maxInstrument = 200;
    private static final int minInstrument = 0;
    
    private int instrument;

    public Instrument(int instrument) {
    	this.instrument = instrument;
    }
    public Instrument() {
    	this.instrument = defaultInstrument;
    }

    public void update(InstrumentAlteration alterInstrument) {
    	
    }

    public int getInstrument() {
    	return instrument;
    }
}
