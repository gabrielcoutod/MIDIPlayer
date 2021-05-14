package player;

// Represents an Instrument.
public class Instrument {
	
	// Constants
    public static final int defaultInstrument = 6;
    public static final int maxInstrument = 127;
    public static final int minInstrument = 0;

    // Attribute for current instrument
    private int instrument;

    // Argument constructor
    public Instrument(int instrument) {
        this.instrument = instrument;
    }

    // Default constructor
    public Instrument() {
        this.instrument = defaultInstrument;
    }
    
    // Setter
    public void setInstrument(int newInstrument) {
        instrument = newInstrument;
        if (instrument > maxInstrument)
            instrument = maxInstrument;
        else if (instrument < minInstrument)
            instrument = minInstrument;
    }

    // Getter
    public int getInstrument() {
        return instrument;
    }
}
