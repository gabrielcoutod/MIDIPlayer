package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.Octave;
import player.TCPlayer;
import symbol.OctaveIncrementAlteration;

// Class for OctaveIncrementAlteration tests
class OctaveIncrementAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for increment
	void octaveIncrementTest() {
		int initialOctave = player.getOctave();
		new OctaveIncrementAlteration().alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(initialOctave + 1, afterAlteration);
	}
	
	@Test
	// Test for when the new value will be over the upper limit
	void octaveIncrementOverTest() {
		player.setOctave(Octave.maxOctave);
		new OctaveIncrementAlteration().alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(Octave.defaultOctave, afterAlteration);
	}
	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialInstrument = player.getInstrument();
		int initialBPM= player.getBPM();
		new OctaveIncrementAlteration().alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialInstrument == player.getInstrument() && initialBPM == player.getBPM());
	}

}
