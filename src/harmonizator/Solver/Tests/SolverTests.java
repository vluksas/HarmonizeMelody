package harmonizator.Solver.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Rules.ParallelFifths;
import harmonizator.Rules.RuleSet;
import harmonizator.Solver.Solver;

import org.junit.Test;

public class SolverTests {
	private ChordSelector cs;
	public SolverTests(){
		cs = new ChordSelector();
	}
	@Test
	public void testHarmonizeOneNote() {
		Solver s = new Solver();
		s.addNote(new Note(49));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = new ArrayList<Chord>();
		cs.reset();
		cs.selectT5();
		expected.add(cs.buildChord());
		assertEquals(expected.get(0),actual.get(0));
	}
	@Test
	public void testHarmonizeOneNoteLowerOct() {
		Solver s = new Solver();
		s.addNote(new Note(37));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = new ArrayList<Chord>();
		cs.reset();
		cs.selectOct(2);
		cs.selectT5();
		expected.add(cs.buildChord());
		assertEquals(expected.get(0),actual.get(0));
	}
	@Test
	public void testHarmonizeOneNoteIncorrect() {
		Solver s = new Solver();
		s.addNote(new Note(38));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = new ArrayList<Chord>();
		expected.add(null);
		assertEquals(expected.get(0),actual.get(0));
	}
	@Test
	public void testHarmonizeC_E_F() {
		Solver s = new Solver();
		s.addNote(new Note(37));
		s.addNote(new Note(41));
		s.addNote(new Note(42));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = new ArrayList<Chord>();
		//building the expected solution:
		cs.reset();
		cs.selectOct(2);
		cs.selectT5();
		expected.add(cs.buildChord());
		cs.selectTopPos(ChordPosition.Third);
		expected.add(cs.buildChord());
		cs.selectS5();
		cs.selectTopPos(ChordPosition.Prime);
		expected.add(cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testHarmonizeG_E_C() {
		Solver s = new Solver();
		s.addNote(new Note(44));
		s.addNote(new Note(41));
		s.addNote(new Note(37));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = new ArrayList<Chord>();
		//building the expected solution:
		cs.reset();
		cs.selectOct(2);
		cs.selectT5();
		cs.selectTopPos(ChordPosition.Fifth);
		expected.add(cs.buildChord());
		cs.selectTopPos(ChordPosition.Third);
		expected.add(cs.buildChord());
		cs.selectS5();
		cs.selectTopPos(ChordPosition.Fifth);
		cs.selectOct(1);
		expected.add(cs.buildChord());
		assertEquals(expected,actual);
	}

}
