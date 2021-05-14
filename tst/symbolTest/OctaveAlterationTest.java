package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.Octave;
import player.TCPlayer;
import symbol.OctaveAlteration;

// Class for BPMAlteration tests
class OctaveAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	void octavePositiveAlterationTest() {
		int initialOctave = player.getOctave();
		new OctaveAlteration(OctaveAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(initialOctave + OctaveAlteration.positiveAlteration,afterAlteration);
	}
	
	@Test
	void octaveNegativeAlterationTest() {
		int initialOctave = player.getOctave();
		new OctaveAlteration(OctaveAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(initialOctave + OctaveAlteration.negativeAlteration,afterAlteration);
	}
	
	@Test
	void octavePositiveAlterationOverTest() {
		player.setOctave(Octave.maxOctave);
		new OctaveAlteration(OctaveAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(Octave.maxOctave,afterAlteration);
	}
	
	@Test
	void octaveegativeAlterationUnderTest() {
		player.setOctave(Octave.minOctave);
		new OctaveAlteration(OctaveAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getOctave();
		assertEquals(Octave.minOctave,afterAlteration);
	}
	
	@Test
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialInstrument = player.getInstrument();
		int initialBPM= player.getBPM();
		new OctaveAlteration(OctaveAlteration.positiveAlteration).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialInstrument == player.getInstrument() && initialBPM == player.getBPM());
	}

}
