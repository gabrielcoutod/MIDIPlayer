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

class InputConverterTest {

	@Test
	void BPMChangeTest() {
		Symbol[] symbolArray = InputConverter.convert("BPM+BPN+BPM-MBPN--+-+=BBPM-BBPM+BPM");
		Symbol[] expectedResult = {
				new BPMAlteration(50), 
				new Note(Notes.B), new Note(Notes.P), new Note(Notes.P), new VolumeAlteration(10),
				new BPMAlteration(-50),
				new Note(Notes.P), new Note(Notes.B), new Note(Notes.P), new Note(Notes.P), new VolumeAlteration(-10),
				new VolumeAlteration(-10), new VolumeAlteration(10), new VolumeAlteration(-10), new VolumeAlteration(10), new Note(Notes.P),
				new Note(Notes.B), new BPMAlteration(-50), new Note(Notes.B), new BPMAlteration(50),
				new Note(Notes.B), new Note(Notes.P), new Note(Notes.P)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	void NotesTest() {
		Symbol[] symbolArray = InputConverter.convert("ABCDEFGPabAbEbbJJDJjFHGgBPM+gBT");
		Symbol[] expectedResult = {
				new Note(Notes.A), new Note(Notes.B), new Note(Notes.C), new Note(Notes.D), new Note(Notes.E), new Note(Notes.F), new Note(Notes.G),
				new Note(Notes.P), new Note(Notes.P), new Note(Notes.P), new Note(Notes.A), new Note(Notes.A),
				new Note(Notes.E), new Note(Notes.E), new Note(Notes.E), new Note(Notes.E), new Note(Notes.E),
				new Note(Notes.D), new Note(Notes.D), new Note(Notes.D), new Note(Notes.F), new Note(Notes.F),
				new Note(Notes.G), new Note(Notes.G), new BPMAlteration(50), new Note(Notes.P),
				new Note(Notes.B), new Note(Notes.B)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	void InstrumentTest() {
		Symbol[] symbolArray = InputConverter.convert(",;\nOUIoui!0123456789");
		Symbol[] expectedResult = {
				new InstrumentAlteration(20), new InstrumentAlteration(76), new InstrumentAlteration(15), new InstrumentAlteration(7),
				new InstrumentAlteration(7), new InstrumentAlteration(7), new InstrumentAlteration(7), new InstrumentAlteration(7),
				new InstrumentAlteration(7), new InstrumentAlteration(114),
				new InstrumentRelativeAlteration(0), new InstrumentRelativeAlteration(1), new InstrumentRelativeAlteration(2),
				new InstrumentRelativeAlteration(3), new InstrumentRelativeAlteration(4), new InstrumentRelativeAlteration(5),
				new InstrumentRelativeAlteration(6), new InstrumentRelativeAlteration(7), new InstrumentRelativeAlteration(8),
				new InstrumentRelativeAlteration(9)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	void octaveTest() {
		Symbol[] symbolArray = InputConverter.convert("T+T-TATtT+BT-?.T");
		Symbol[] expectedResult = {
					new OctaveAlteration(1), new OctaveAlteration(-1), new Note(Notes.P), new Note(Notes.A),
					new Note(Notes.A), new Note(Notes.A), new OctaveAlteration(1), new Note(Notes.B),
					new OctaveAlteration(-1), new OctaveIncrementAlteration(), new OctaveIncrementAlteration(), new Note(Notes.P)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	void volumeTest() {
		Symbol[] symbolArray = InputConverter.convert("++--  -+  ");
		Symbol[] expectedResult = {
					new VolumeAlteration(10), new VolumeAlteration(10), new VolumeAlteration(-10), new VolumeAlteration(-10),
					new VolumeDoubleAlteration(), new VolumeDoubleAlteration(),  new VolumeAlteration(-10), new VolumeAlteration(10),
					new VolumeDoubleAlteration(), new VolumeDoubleAlteration()
				};
		assertArrayEquals(symbolArray, expectedResult);
	}
	
	@Test
	void randomNoteTest() {
		Symbol[] symbolArray = InputConverter.convert("R");
		assertTrue(symbolArray.length == 1 && Note.getMusicalNotes().contains(symbolArray[0]));
	}

}
