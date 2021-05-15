package symbolTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import player.TCPlayer;
import symbol.InstrumentAlteration;

// Class for InstrumentAlteration tests
class InstrumentAlterationTest {
	
	private TCPlayer player = new TCPlayer();

	@Test
	// Test for Agogo change
	void instrumentAlterationAgogoTest() {
		player.setInstrument(InstrumentAlteration.churchOrgan);
		new InstrumentAlteration(InstrumentAlteration.agogo).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(InstrumentAlteration.agogo, afterAlteration);
	}
	
	@Test
	// Test for Church Organ change
	void instrumentAlterationChurchOrganTest() {
		player.setInstrument(InstrumentAlteration.agogo);
		new InstrumentAlteration(InstrumentAlteration.churchOrgan).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(InstrumentAlteration.churchOrgan, afterAlteration);
	}
	
	@Test
	// Test for Hapsichord change
	void instrumentAlterationHapsichordTest() {
		player.setInstrument(InstrumentAlteration.churchOrgan);
		new InstrumentAlteration(InstrumentAlteration.hapsichord).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(InstrumentAlteration.hapsichord, afterAlteration);
	}
	
	@Test
	// Test for Pan Flute change
	void instrumentAlterationPanFluteTest() {
		player.setInstrument(InstrumentAlteration.churchOrgan);
		new InstrumentAlteration(InstrumentAlteration.panFlute).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(InstrumentAlteration.panFlute, afterAlteration);
	}
	
	@Test
	// Test for Tubular Bells change
	void instrumentAlterationTubularBellsTest() {
		player.setInstrument(InstrumentAlteration.churchOrgan);
		new InstrumentAlteration(InstrumentAlteration.tubularBells).alterPlayer(player);
		int afterAlteration = player.getInstrument();
		assertEquals(InstrumentAlteration.tubularBells, afterAlteration);
	}

	
	@Test
	// Test to verify if the symbol doesn't change any other parameter
	void onlyOneAlterationTest() {
		int initialVolume = player.getVolume();
		int initialBPM = player.getBPM();
		int initialOctave= player.getOctave();
		new InstrumentAlteration(InstrumentAlteration.tubularBells).alterPlayer(player);
		assertTrue(initialVolume == player.getVolume() && initialBPM == player.getBPM() && initialOctave == player.getOctave());
	}

}
