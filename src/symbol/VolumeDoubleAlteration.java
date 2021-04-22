package symbol;

//Symbol from input text that represents the change to 
//default volume or double the current volume.
public class VolumeDoubleAlteration extends Symbol {
    private boolean doubleVolume;

    public VolumeDoubleAlteration(boolean doubleVolume) {
    	this.doubleVolume = doubleVolume;
    }

    public boolean isDouble() {
    	return doubleVolume;
    }
    public boolean isDefault() {
    	return !doubleVolume;
    }
}
