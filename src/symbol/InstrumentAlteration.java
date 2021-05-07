package symbol;
// Symbol from input text that represents the instrument change.
public class InstrumentAlteration extends Symbol {
    private int newInstrument;
    private boolean relative;
    /*
        boolean relative explanation:
        If it is meant to set or increment the current instrument. Set: false. Increment: true.
        This is needed because we cannot know the current instrument in runtime, and both functionalities
        (set and increment) are required in our specification. If we could know what the current instrument
        was, there would be no need for this variable, as it would be trivial to assign
        newInstrument = currentInstrument + value, but we have no way of knowing the instrument in
        the text to symbol array translation (where this symbol is created), therefore the boolean variable
        "relative" is needed.
     */

    public InstrumentAlteration(int instrument, boolean relative) {
    	this.newInstrument = instrument;
    	this.relative = relative;
    }

    public int getInstrument() {
    	return newInstrument;
    }

    public boolean isRelative() {
        return relative;
    }
}