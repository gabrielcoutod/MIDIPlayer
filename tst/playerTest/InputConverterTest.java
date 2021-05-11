package playerTest;

import static org.junit.jupiter.api.Assertions.*;
import player.InputConverter;
import symbol.BPMAlteration;
import symbol.Note;
import symbol.Notes;
import symbol.Symbol;
import symbol.VolumeAlteration;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InputConverterTest {

	@Test
	void testBPMMenosEMais() {
		Symbol[] symbolArray = InputConverter.convert("BPM+BPN+BPM-BPN--+-+=");
		Symbol[] expectedResult = {
				new BPMAlteration(50), 
				new Note(Notes.B), new Note(Notes.P), new Note(Notes.P), new VolumeAlteration(10),
				new BPMAlteration(-50),
				new Note(Notes.B), new Note(Notes.P), new Note(Notes.P), new VolumeAlteration(-10),
				new VolumeAlteration(-10), new VolumeAlteration(10), new VolumeAlteration(-10), new VolumeAlteration(10), new Note(Notes.P)
				};
		assertArrayEquals(symbolArray, expectedResult);
	}

}
