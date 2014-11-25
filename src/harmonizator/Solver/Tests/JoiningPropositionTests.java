package harmonizator.Solver.Tests;

import static org.junit.Assert.*;
import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordVariation;
import harmonizator.Solver.JoiningPropositions.*;

import org.junit.Test;

public class JoiningPropositionTests {

	@Test
	public void testOneLink() {
		ChordSuggestion expected = new ChordSuggestion();
		expected.setScDeg(ScaleDegree.Tonic);
		expected.setChordVariation(ChordVariation.P5);
		JoiningProposition link1 = new KeepSameProposition(null);
		ChordSelector cs = new ChordSelector();
		ChordSuggestion actual = link1.suggest(0, cs.buildChord());
		assertEquals(expected,actual); 
	}
	@Test
	public void testBasicChain(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.setScDeg(ScaleDegree.Tonic);
		expected.setChordVariation(ChordVariation.P6);
		JoiningProposition base = new KeepSameProposition(null);
		JoiningProposition link2 = new TonicProposition(null);
		JoiningProposition link3 = new KeepSDSwitchInversionProposition(null);
		JoiningProposition link4 = new DominantProposition(null);
		base.setNext(link2);
		link2.setNext(link3);
		link3.setNext(link4);
		ChordSelector cs = new ChordSelector();
		cs.selectT5();
		ChordSuggestion actual = base.suggest(2, cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testBasicChainWithSkips(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.setScDeg(ScaleDegree.Dominant);
		expected.setChordVariation(ChordVariation.P5);
		JoiningProposition base = new KeepSameProposition(null);
		JoiningProposition link2 = new TonicProposition(null);
		JoiningProposition link3 = new KeepSDSwitchInversionProposition(null);
		JoiningProposition link4 = new DominantProposition(null);
		base.setNext(link2);
		link2.setNext(link3);
		link3.setNext(link4);
		ChordSelector cs = new ChordSelector();
		cs.selectD2();
		ChordSuggestion actual = base.suggest(2, cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testExpositionalHarmonyChain(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.setScDeg(ScaleDegree.Dominant);
		expected.setChordVariation(ChordVariation.P5);
		JoiningProposition base = createExpositionalHarmonyChain();
		ChordSelector cs = new ChordSelector();
		cs.selectD5();
		ChordSuggestion actual = base.suggest(0, cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testExpositionalHarmonyChain_3(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.setScDeg(ScaleDegree.Tonic);
		expected.setChordVariation(ChordVariation.P6);
		JoiningProposition base = createExpositionalHarmonyChain();
		ChordSelector cs = new ChordSelector();
		cs.selectD5();
		ChordSuggestion actual = base.suggest(3, cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testExpositionalHarmonyChain_6(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.setScDeg(ScaleDegree.Supertonic);
		expected.setChordVariation(ChordVariation.P6);
		JoiningProposition base = createExpositionalHarmonyChain();
		ChordSelector cs = new ChordSelector();
		cs.selectT6();
		ChordSuggestion actual = base.suggest(6, cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testExpositionalHarmonyChain_OutOfBounds(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.unset();
		JoiningProposition base = createExpositionalHarmonyChain();
		ChordSelector cs = new ChordSelector();
		cs.selectT6();
		ChordSuggestion actual = base.suggest(16, cs.buildChord());
		assertEquals(expected,actual);
	}
	@Test
	public void testExpositionalHarmonyChain_SubTonicSkips(){
		ChordSuggestion expected = new ChordSuggestion();
		expected.unset();
		JoiningProposition base = createExpositionalHarmonyChain();
		ChordSelector cs = new ChordSelector();
		cs.selectX6();
		cs.selectScaleDegree(2);
		ChordSuggestion actual = base.suggest(6, cs.buildChord());
		assertEquals(expected,actual);
	}
	private JoiningProposition createExpositionalHarmonyChain() {
		JoiningProposition links[] = new JoiningProposition[JoiningProposition.MAX_PREFERENCE*2+1];
		links[JoiningProposition.MAX_PREFERENCE*2] = null;
		for(int i = JoiningProposition.MAX_PREFERENCE;i >= JoiningProposition.MIN_PREFERENCE;i--){
			links[i*2-1] = new SwitchSDSwitchInversionProposition(links[i*2],i);
			links[i*2-2] = new SwitchSDKeepInversionProposition(links[i*2-1],i);
		}
		JoiningProposition link2 = new KeepSDSwitchInversionProposition(links[0]);
		JoiningProposition base = new KeepSameProposition(link2);
		return base;
	}

}
