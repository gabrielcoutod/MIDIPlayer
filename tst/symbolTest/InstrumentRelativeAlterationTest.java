package symbolTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.Instrument;
import player.TCPlayer;
import symbol.InstrumentRelativeAlteration;

// Class for BPMAlteration tests
class InstrumentRelativeAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	void instrumentPositiveRelativeAlterationTest() {
		int initialInstrument = player.getInstrument();
		int change = 2;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(initialInstrument + change,afterAlteration);
	}
	
	@Test
	void instrumentNegativeRelativeAlterationTest() {
		int initialInstrument = player.getInstrument();
		int change = -3;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(initialInstrument + change,afterAlteration);
	}
	
	@Test
	void instrumentPositiveRelativeAlterationOverTest() {
		player.setInstrument(Instrument.maxInstrument);
		int change = 4;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(Instrument.maxInstrument,afterAlteration);
	}
	
	@Test
	void instrumentNegativeRelativeAlterationUnderTest() {
		player.setInstrument(Instrument.minInstrument);
		int change = -5;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(Instrument.minInstrument,afterAlteration);
	}
	
	@Test
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialBPM = player.getBPM();
		int initialOctave= player.getOctave();
		int change = 6;
		new InstrumentRelativeAlteration(change).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialBPM == player.getBPM() && initialOctave == player.getOctave());
	}

}
