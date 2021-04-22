package symbol;
// Symbol from input text that represents the instrument change.
public class InstrumentAlteration extends Symbol {
    private int newInstrument;

    public InstrumentAlteration(int instrument) {
    	this.newInstrument = instrument;
    }

    public int getInstrument() {
    	return newInstrument;
    }
}