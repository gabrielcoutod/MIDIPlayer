package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.BPM;
import player.TCPlayer;
import symbol.BPMAlteration;

// Class for BPMAlteration tests
class BPMAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	void BPMPositiveAlterationTest() {
		int initialBPM = player.getBPM();
		new BPMAlteration(BPMAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(initialBPM + BPMAlteration.positiveAlteration,afterAlteration);
	}
	
	@Test
	void BPMNegativeAlterationTest() {
		int initialBPM = player.getBPM();
		new BPMAlteration(BPMAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(initialBPM + BPMAlteration.negativeAlteration,afterAlteration);
	}
	
	@Test
	void BPMPositiveAlterationOverTest() {
		player.setBPM(BPM.maxBPM);
		new BPMAlteration(BPMAlteration.positiveAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(BPM.maxBPM,afterAlteration);
	}
	
	@Test
	void BPMNegativeAlterationUnderTest() {
		player.setBPM(BPM.minBPM);
		new BPMAlteration(BPMAlteration.negativeAlteration).alterPlayer(player);
		int afterAlteration = player.getBPM();
		assertEquals(BPM.minBPM,afterAlteration);
	}
	
	@Test
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialInstrument = player.getInstrument();
		int initialOctave= player.getOctave();
		new BPMAlteration(BPMAlteration.positiveAlteration).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialInstrument == player.getInstrument() && initialOctave == player.getOctave());
	}

}
