package playerTest;

import static org.junit.jupiter.api.Assertions.*;
import player.InputConverter;
import symbol.BPMAlteration;
import symbol.InstrumentAlteration;
import symbol.InstrumentRelativeAlteration;
import symbol.Note;
import symbol.Notes;
import symbol.OctaveAlteration;
import symbol.OctaveIncrementAlteration;
import symbol.Symbol;
import symbol.VolumeAlteration;
import symbol.VolumeDoubleAlteration;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

// Tests for the InputConverter
class InputConverterTest {

	@Test
	// Test for BPM changes
	void BPMChangeTest() {
		Symbol[] symbolArray = InputConverter.convert("BPM+BPN+BPM-MBPN--+-+=BBPM-BBPM+BPM");
		Symbol[] expectedResult = {
				new BPMAlteration(BPMAlteration.positiveAlteration), 
				new Note(Notes.B), new Note(Notes.P), new Note(Notes.P), new VolumeAlteration(VolumeAlteration.positiveAlteration),
				new BPMAlteration(BPMAlteration.negativeAlteration),
				new Note(Notes.P), new Note(Notes.B), new Note(Notes.P), new Note(Notes.P), new VolumeAlteration(VolumeAlteration.negativeAlteration),
				new VolumeAlteration(VolumeAlteration.negativeAlteration), new VolumeAlteration(VolumeAlteration.positiveAlteration), 
				new VolumeAlteration(VolumeAlteration.negativeAlteration), new VolumeAlteration(VolumeAlteration.positiveAlteration), new Note(Notes.P),
				new Note(Notes.B), new BPMAlteration(BPMAlteration.negativeAlteration), new Note(Notes.B), new BPMAlteration(BPMAlteration.positiveAlteration),
				new Note(Notes.B), new Note(Notes.P), new Note(Notes.P)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	// Test for notes
	void NotesTest() {
		Symbol[] symbolArray = InputConverter.convert("ABCDEFGPabAbEbbJJDJjFHGgBPM+gBT");
		Symbol[] expectedResult = {
				new Note(Notes.A), new Note(Notes.B), new Note(Notes.C), new Note(Notes.D), new Note(Notes.E), new Note(Notes.F), new Note(Notes.G),
				new Note(Notes.P), new Note(Notes.P), new Note(Notes.P), new Note(Notes.A), new Note(Notes.A),
				new Note(Notes.E), new Note(Notes.E), new Note(Notes.E), new Note(Notes.E), new Note(Notes.E),
				new Note(Notes.D), new Note(Notes.D), new Note(Notes.D), new Note(Notes.F), new Note(Notes.F),
				new Note(Notes.G), new Note(Notes.G), new BPMAlteration(BPMAlteration.positiveAlteration), new Note(Notes.P),
				new Note(Notes.B), new Note(Notes.B)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	// Test for instrument changes
	void InstrumentTest() {
		Symbol[] symbolArray = InputConverter.convert(",;\nOUIoui!0123456789");
		Symbol[] expectedResult = {
				new InstrumentAlteration(InstrumentAlteration.churchOrgan), new InstrumentAlteration(InstrumentAlteration.panFlute), 
				new InstrumentAlteration(InstrumentAlteration.tubularBells), new InstrumentAlteration(InstrumentAlteration.hapsichord),
				new InstrumentAlteration(InstrumentAlteration.hapsichord), new InstrumentAlteration(InstrumentAlteration.hapsichord), 
				new InstrumentAlteration(InstrumentAlteration.hapsichord), new InstrumentAlteration(InstrumentAlteration.hapsichord),
				new InstrumentAlteration(InstrumentAlteration.hapsichord), new InstrumentAlteration(InstrumentAlteration.agogo),
				new InstrumentRelativeAlteration(0), new InstrumentRelativeAlteration(1), new InstrumentRelativeAlteration(2),
				new InstrumentRelativeAlteration(3), new InstrumentRelativeAlteration(4), new InstrumentRelativeAlteration(5),
				new InstrumentRelativeAlteration(6), new InstrumentRelativeAlteration(7), new InstrumentRelativeAlteration(8),
				new InstrumentRelativeAlteration(9)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	// Test for the octave changes
	void octaveTest() {
		Symbol[] symbolArray = InputConverter.convert("T+T-TATtT+BT-?.T");
		Symbol[] expectedResult = {
					new OctaveAlteration(OctaveAlteration.positiveAlteration), new OctaveAlteration(OctaveAlteration.negativeAlteration), new Note(Notes.P), new Note(Notes.A),
					new Note(Notes.A), new Note(Notes.A), new OctaveAlteration(OctaveAlteration.positiveAlteration), new Note(Notes.B),
					new OctaveAlteration(OctaveAlteration.negativeAlteration), new OctaveIncrementAlteration(), new OctaveIncrementAlteration(), new Note(Notes.P)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	// Test for the volume changes
	void volumeTest() {
		Symbol[] symbolArray = InputConverter.convert("++--  -+  ");
		Symbol[] expectedResult = {
					new VolumeAlteration(VolumeAlteration.positiveAlteration), new VolumeAlteration(VolumeAlteration.positiveAlteration), 
					new VolumeAlteration(VolumeAlteration.negativeAlteration), new VolumeAlteration(VolumeAlteration.negativeAlteration),
					new VolumeDoubleAlteration(), new VolumeDoubleAlteration(),  new VolumeAlteration(VolumeAlteration.negativeAlteration), 
					new VolumeAlteration(VolumeAlteration.positiveAlteration), new VolumeDoubleAlteration(), new VolumeDoubleAlteration()
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	// Test for random note
	void randomNoteTest() {
		Symbol[] symbolArray = InputConverter.convert("R");
		assertTrue(symbolArray.length == 1 && Note.getMusicalNotes().contains(symbolArray[0]));
	}

}
