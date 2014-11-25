package harmonizator.Solver.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Rules.AllVoicesDown;
import harmonizator.Rules.AllVoicesUp;
import harmonizator.Rules.ParallelFifths;
import harmonizator.Rules.ParallelOctaves;
import harmonizator.Rules.RuleSet;
import harmonizator.Solver.Solver;
import harmonizator.Solver.ChordTypePicker.ChordTypePicker;
import harmonizator.Solver.ChordTypePicker.ChordTypePickerArrayAdapter;
import harmonizator.Solver.ChordTypePicker.ChordTypePickerGeneral;
import harmonizator.Solver.ChordTypePicker.S6Picker;

import org.junit.Test;

public class SolverTests {
	private ChordSelector cs;
	public SolverTests(){
		cs = new ChordSelector();
	}
	@Test
	public void testHarmonizeOneNote() {
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		Solver s = new Solver(ctp);
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
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		Solver s = new Solver(ctp);
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
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		Solver s = new Solver(ctp);
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
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		Solver s = new Solver(ctp);
		s.addNote(new Note(37));
		s.addNote(new Note(41));
		s.addNote(new Note(42));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = buildExpectedList_C_E_F();
		assertEquals(expected,actual);
	}
	private ArrayList<Chord> buildExpectedList_C_E_F() {
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
		return expected;
	}
	@Test
	public void testHarmonizeG_E_C() {
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		Solver s = new Solver(ctp);
		s.addNote(new Note(44));
		s.addNote(new Note(41));
		s.addNote(new Note(37));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = buildExpectedList_G_E_C();
		assertEquals(expected,actual);
	}
	private ArrayList<Chord> buildExpectedList_G_E_C() {
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
		return expected;
	}
	@Test
	public void testHarmonizeC_E_F_ArrayPicker() {
		ChordTypePicker ctp = ChordTypePickerArrayAdapter.buildBaseList();
		Solver s = new Solver(ctp);
		s.addNote(new Note(37));
		s.addNote(new Note(41));
		s.addNote(new Note(42));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = buildExpectedList_C_E_F();
		assertEquals(expected,actual);
	}
	@Test
	public void testHarmonizeG_E_C_ArrayPicker() {
		ChordTypePicker ctp = ChordTypePickerArrayAdapter.buildBaseList();
		Solver s = new Solver(ctp);
		s.addNote(new Note(44));
		s.addNote(new Note(41));
		s.addNote(new Note(37));
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = buildExpectedList_G_E_C();
		assertEquals(expected,actual);
	}
	@Test
	public void testHarmonizeC_F() {
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		RuleSet rs = addOctUpDownRules();
		rs.addRule(ParallelFifths.getInstance());
		Solver s = new Solver(ctp);
		s.addToAvailableChords(new S6Picker());
		s.addNote(new Note(37));
		s.addNote(new Note(42));
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = buildExpectedList_C_F();
		removeOctUpDown(rs);
		assertEquals(expected,actual);
	}
	@Test
	public void testHarmonizeC_F_Array() {
		ChordTypePicker ctp = ChordTypePickerArrayAdapter.buildBaseList();
		RuleSet rs = addOctUpDownRules();
		rs.addRule(ParallelFifths.getInstance());
		Solver s = new Solver(ctp);
		s.addToAvailableChords(new S6Picker());
		s.addNote(new Note(37));
		s.addNote(new Note(42));
		ArrayList<Chord> actual = s.solve();
		ArrayList<Chord> expected = buildExpectedList_C_F();
		removeOctUpDown(rs);
		assertEquals(expected,actual);
	}
	private ArrayList<Chord> buildExpectedList_C_F() {
		ArrayList<Chord> expected = new ArrayList<Chord>();
		//building the expected solution:
		cs.reset();
		cs.selectOct(2);
		cs.selectT5();
		cs.selectTopPos(ChordPosition.Prime);
		expected.add(cs.buildChord());
		cs.selectS6();
		cs.selectTopPos(ChordPosition.Prime);
		expected.add(cs.buildChord());
		expected.get(1).bassDown();
		return expected;
	}
	private void removeOctUpDown(RuleSet rs) {
		rs.removeRule(ParallelOctaves.getInstance());
		rs.removeRule(AllVoicesUp.getInstance());
		rs.removeRule(AllVoicesDown.getInstance());
	}
	private RuleSet addOctUpDownRules() {
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelOctaves.getInstance());
		rs.addRule(AllVoicesUp.getInstance());
		rs.addRule(AllVoicesDown.getInstance());
		return rs;
	}

}
