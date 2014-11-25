package harmonizator.Solver.Tests;

import static org.junit.Assert.*;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordSuggestor;
import harmonizator.Solver.ChordVariation;
import harmonizator.Solver.ExpositionalHarmonyGeneralState;

import org.junit.Test;

public class ChordSuggestorTests {
	private static final double DELTA = 1e-6;
	@Test
	public void testMeterConstructor() {
		ChordSuggestor s = new ChordSuggestor(3,4);
		assertEquals(0.75,s.getNotesPerBar(),DELTA);
	}
	@Test
	public void testMeterConstructorNegatives() {
		ChordSuggestor s = new ChordSuggestor(-3,-4);
		assertEquals(0.5,s.getNotesPerBar(),DELTA);
	}
	@Test
	public void testMeterConstructorZero() {
		ChordSuggestor s = new ChordSuggestor(3,0);
		assertEquals(0.5,s.getNotesPerBar(),DELTA);
	}
	@Test
	public void testExpositionalHGeneral() {
		ChordSuggestor cs = new ChordSuggestor();
		ChordSelector csel = new ChordSelector();
		csel.selectT5();
		Chord prev = csel.buildChord();
		cs.setPositionInSolution(1, 0.25);//set state to Expositional
		ChordSuggestion res = cs.suggest(0, prev, new Note(49));
		assertEquals(ScaleDegree.Tonic,res.getScDeg());
		assertEquals(ChordVariation.P5,res.getChordVariation());
	}
	@Test
	public void testExpositionalHGeneralS6() {
		ChordSuggestor cs = new ChordSuggestor();
		ChordSelector csel = new ChordSelector();
		csel.selectS6();
		Chord prev = csel.buildChord();
		cs.setPositionInSolution(1, 0.25);//set state to Expositional
		ChordSuggestion res = cs.suggest(0, prev, new Note(54));
		assertEquals(ScaleDegree.Subdominant,res.getScDeg());
		assertEquals(ChordVariation.P6,res.getChordVariation());
	}
	@Test
	public void testExpositionalHGeneralD7() {
		ChordSuggestor cs = new ChordSuggestor();
		ChordSelector csel = new ChordSelector();
		csel.selectD7();
		Chord prev = csel.buildChord();
		cs.setPositionInSolution(1, 0.25);//set state to Expositional
		ChordSuggestion res = cs.suggest(0, prev, new Note(56));
		assertEquals(ScaleDegree.Dominant,res.getScDeg());
		assertEquals(ChordVariation.P7,res.getChordVariation());
	}


}
