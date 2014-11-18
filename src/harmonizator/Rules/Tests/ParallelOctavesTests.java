package harmonizator.Rules.Tests;


import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Rules.AllVoicesDown;
import harmonizator.Rules.ParallelFifths;
import harmonizator.Rules.ParallelOctaves;

import org.junit.Assert;
import org.junit.Test;

public class ParallelOctavesTests {
	@Test
	public void testCorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		cs.lowerOct();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a2 = cs.buildChord();
		Assert.assertTrue(ParallelOctaves.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testCorrectJoiningAllowedParallelOctaves() {
		ChordSelector cs = new ChordSelector();
		cs.selectK64();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a1 = cs.buildChord();
		cs.selectD5();
		cs.selectTopPos(ChordPosition.Prime);
		Chord a2 = cs.buildChord();
		Assert.assertTrue(ParallelOctaves.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testIncorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Chord a2 = cs.buildChord();
		Assert.assertFalse(ParallelOctaves.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testIncorrectJoiningWide() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Chord a2 = cs.buildChord();
		a2.bassDown();
		Assert.assertFalse(ParallelOctaves.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testDifferentChords() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Note[] notes = {new Note(6),new Note(12)};
		Chord a2 = new ChordGeneric(notes);
		Assert.assertFalse(ParallelOctaves.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testNull(){
		Assert.assertTrue(ParallelOctaves.getInstance().correctJoining(null, null));
	}
}
