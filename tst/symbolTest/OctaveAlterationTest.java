package symbolTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import player.Octave;
import player.TCPlayer;
import symbol.OctaveAlteration;

// Class for OctaveAlteration tests
class OctaveAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for positive alteration
	void octavePositiveAlterationTest() {
		int initialOctave = player.getOctave();
		new OctaveAlteration(OctaveAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(initialOctave + OctaveAlteration.positiveAlteration,afterAlteration);
	}
	
	@Test
	// Test for negative alteration
	void octaveNegativeAlterationTest() {
		int initialOctave = player.getOctave();
		new OctaveAlteration(OctaveAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(initialOctave + OctaveAlteration.negativeAlteration,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be over the upper limit
	void octavePositiveAlterationOverTest() {
		player.setOctave(Octave.maxOctave);
		new OctaveAlteration(OctaveAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(Octave.maxOctave,afterAlteration);
	}
	
	@Test
	// Test for when the new value will be under the lower limit
	void octaveNegativeAlterationUnderTest() {
		player.setOctave(Octave.minOctave);
		new OctaveAlteration(OctaveAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(Octave.minOctave,afterAlteration);
	}
	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialInstrument = player.getInstrument();
		int initialBPM= player.getBPM();
		new OctaveAlteration(OctaveAlteration.positiveAlteration).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialInstrument == player.getInstrument() && initialBPM == player.getBPM());
	}

}
