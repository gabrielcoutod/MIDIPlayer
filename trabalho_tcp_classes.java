// Receives the characters from the input,
// determines the parameters of the music and plays/saves it.
public class Player {
    private Octave octave;
    private BPM bpm;
    private Volume volume;
    private Instrument instrument;

    public Player();

    public Player(int octave, int bpm, int volume, int instrument);

    private void action(AlterBPM alteration);

    private void action(AlterVolume alteration);

    private void action(AlterVolumeDouble alteration);

    private void action(AlterInstrument alteration);

    private void action(AlterOctave alteration);

    private void action(Note note);

    private void play(Symbol[] music);

    private void save(Symbol[] music);
}

// Represents an octave.
public class Octave {
    private static final int defaultOctave = 0;
    private static final int maxOctave = 5;
    private static final int minOctave = -5;
    
    private int octave;

    public Octave(int octave);
    public Octave();

    public void update(AlterOctave alterOctave);

    public int getOctave();
}

// Represents a BPM.
public class BPM {
    private static final int defaultBPM = 50;
    private static final int maxBPM = 1000;
    private static final int minBPM = 50;

    private int bpm;

    public BPM(int bpm);
    public BPM();

    public void update(AlterBPM alterBPM);

    public int getBPM();
}

// Represents a volume.
public class Volume {
    private static final int defaultVolume= 10;
    private static final int maxVolume = 100;
    private static final int minVolume = 0;
    
    private int volume;

    public Volume(int volume);
    public Volume();

    public void update(AlterVolume alterVolume);
    public void update(AlterVolumeDouble alterVolume);

    public int getVolume();
}

// Enum for the possible instruments.
public enum Instruments {
    Piano, Guitar, Saxophone, Flute, Violin;
}

// Represents an Instrument.
public class Instrument {
    private static final Instruments defaultInstrument = Instruments.Piano;
    
    private Instruments instrument;

    public Instrument(Instruments instrument);
    public Instrument();

    public void update(AlterInstrument alterInstrument);

    public Instruments getInstrument();
}


// Symbol is an abstract superclass for all 
// the symbols that can be read as input.
public abstract class Symbol;

// Possible Notes.
// P is a pause.
public enum Notes {
    A, B, C, D, E, F, G, ASharp, CSharp, DSharp, FSharp, GSharp, P;
}

// Symbol from input text that represents a Note.
public class Note extends Symbol {
    private Notes note;

    public Note(Notes note);

    public Notes getNote();
}

// Symbol from input text that represents the BPM change.
public class AlterBPM extends Symbol {
    private int difference;

    public AlterBPM(int value);

    public int getDifference();
}

// Symbol from input text that represents the octave change.
public class AlterOctave extends Symbol {
    private int difference;

    public AlterOctave(int value);

    public int getDifference();
}

// Symbol from input text that represents the volume change.
public class AlterVolume extends Symbol {
    private int difference;

    public AlterVolume(int value);

    public int getDifference();
}

// Symbol from input text that represents the change to 
// default volume or double the current volume.
public class AlterVolumeDouble extends Symbol {
    private boolean doubleVolume;

    public AlterVolumeDouble(boolean doubleVolume);

    public boolean isDouble();
    public boolean isDefault();
}

// Symbol from input text that represents the instrument change.
public class AlterInstrument extends Symbol {
    public AlterInstrument();
}

// Class for converting from text input to Symbols.
class InputConverter {
    public static Symbol[] convert(String text_in);
}

// Main class.
class App {
    public static void main(String[] args);
}

// Class for main application window. 
class MainWindow {

    public MainWindow();

    public void help();

    public void about();

    public void file();

    public void addNote();

    public void updateOptions();

    public void playMusic();

    public void clearMusic();
}

// Class for 'Help' window.
class Help {

    public Help();

    public void helpMessage();
}

// Class for 'About' window.
class About {

    public About();

    public void aboutMessage();
}

// Class for 'File' window.
class FileWindow {

    public FileWindow();

    public void openFile();

    public void saveFile();

    public void saveMusic();
}
