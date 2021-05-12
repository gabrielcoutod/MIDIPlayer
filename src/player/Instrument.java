package player;

//Represents an Instrument.
public class Instrument {
    public static final int defaultInstrument = 7;
    public static final int maxInstrument = 200;
    public static final int minInstrument = 0;

    private int instrument;

    public Instrument(int instrument) {
        this.instrument = instrument;
    }

    public Instrument() {
        this.instrument = defaultInstrument;
    }

    public void setInstrument(int newInstrument) {
        instrument = newInstrument;
        if (instrument > maxInstrument)
            instrument = maxInstrument;
        else if (instrument < minInstrument)
            instrument = minInstrument;
    }

    public int getInstrument() {
        return instrument;
    }
}
