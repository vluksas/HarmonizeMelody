package harmonizator.Solver.Tests;

import static org.junit.Assert.*;
import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordSelector;
import harmonizator.Chords.ChordType;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordVariation;
import harmonizator.Solver.ChordTypePicker.ChordTypePicker;
import harmonizator.Solver.ChordTypePicker.ChordTypePickerGeneral;
import harmonizator.Solver.ChordTypePicker.D5Picker;
import harmonizator.Solver.ChordTypePicker.T5Picker;
import harmonizator.Solver.ChordTypePicker.X5Picker;

import org.junit.Test;

public class ChordTypePickerTests {
	@Test
	public void testBuildBaseStructure1() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		assertEquals(ChordType.Trichord, tree.getChild(0).getChordSuggestion().getChordType());
	}
	@Test
	public void testBuildBaseStructure2() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		assertEquals(ChordVariation.P6, tree.getChild(0).getChild(1).getChordSuggestion().getChordVariation());
	}
	@Test
	public void testBuildBaseStructure3() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		assertEquals(ChordVariation.P34, tree.getChild(1).getChild(2).getChordSuggestion().getChordVariation());
	}
	@Test
	public void testBuildBaseStructure4() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		assertEquals(ScaleDegree.Tonic, tree.getChild(1).getChild(2).getChild(0).getChordSuggestion().getScDeg());
	}	
	@Test
	public void testBuildBaseStructure5() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		assertEquals(ScaleDegree.Mediant, tree.getChild(1).getChild(0).getChild(2).getChordSuggestion().getScDeg());
	}
	@Test
	public void testBuildBaseStructureT5Picker() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		tree.add(new T5Picker());
		assertEquals(ScaleDegree.Tonic, tree.getChild(0).getChild(0).getChild(0).getChild(0).getChordSuggestion().getScDeg());
	}
	@Test
	public void testBuildBaseStructureT5Picker_pick() {
		ChordSelector cs = new ChordSelector();
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		tree.add(new T5Picker());
		ChordSuggestion csug = new ChordSuggestion();
		csug.setChordVariation(ChordVariation.P5);
		csug.setScDeg(ScaleDegree.Tonic);
		cs.selectD2();
		tree.pickType(cs, csug);
		Chord c = cs.buildChord();
		cs.reset();
		cs.selectT5();
		Chord expected = cs.buildChord();
		assertEquals(expected,c);
	}
	@Test
	public void testBuildBaseStructureD5Picker() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		tree.add(new D5Picker());
		assertEquals(ScaleDegree.Dominant, tree.getChild(0).getChild(0).getChild(4).getChild(0).getChordSuggestion().getScDeg());
	}
	@Test
	public void testBuildBaseStructureD5Picker_pick() {
		ChordSelector cs = new ChordSelector();
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		tree.add(new D5Picker());
		ChordSuggestion csug = new ChordSuggestion();
		csug.setChordVariation(ChordVariation.P5);
		csug.setScDeg(ScaleDegree.Dominant);
		cs.selectVII2();
		tree.pickType(cs, csug);
		Chord c = cs.buildChord();
		cs.reset();
		cs.selectD5();
		Chord expected = cs.buildChord();
		assertEquals(expected,c);
	}
	@Test
	public void testBuildBaseStructureIII5Picker() {
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		tree.add(new X5Picker(ScaleDegree.Mediant));
		assertEquals(ScaleDegree.Mediant, tree.getChild(0).getChild(0).getChild(2).getChild(0).getChordSuggestion().getScDeg());
	}
	@Test
	public void testBuildBaseStructureMediant_5Picker_pick() {
		ChordSelector cs = new ChordSelector();
		ChordTypePicker tree = ChordTypePickerGeneral.buildBaseTree();
		tree.add(new X5Picker(ScaleDegree.Mediant));
		ChordSuggestion csug = new ChordSuggestion();
		csug.setChordVariation(ChordVariation.P5);
		csug.setScDeg(ScaleDegree.Mediant);
		cs.selectVII2();
		tree.pickType(cs, csug);
		Chord c = cs.buildChord();
		cs.reset();
		cs.selectScaleDegree(ScaleDegree.Mediant);
		Chord expected = cs.buildChord();
		assertEquals(expected,c);
	}
}
