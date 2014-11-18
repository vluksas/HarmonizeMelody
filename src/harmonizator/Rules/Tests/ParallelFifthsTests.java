package harmonizator.Rules.Tests;

import static org.junit.Assert.assertEquals;
import harmonizator.Note;
import harmonizator.NoteFactory;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Rules.AllVoicesDown;
import harmonizator.Rules.ParallelFifths;

import org.junit.Assert;
import org.junit.Test;

public class ParallelFifthsTests {
	@Test
	public void testCorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		cs.lowerOct();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a2 = cs.buildChord();
		Assert.assertTrue(ParallelFifths.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testCorrectJoiningSameChord() {
		ChordSelector cs = new ChordSelector();
		cs.selectD5();
		Chord a1 = cs.buildChord();
		cs.selectD7();
		Chord a2 = cs.buildChord();
		Assert.assertTrue(ParallelFifths.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testIncorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Chord a2 = cs.buildChord();
		Assert.assertFalse(ParallelFifths.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testIncorrectJoiningWide() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Chord a2 = cs.buildChord();
		a2.bassDown();
		Assert.assertFalse(ParallelFifths.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testDifferentChords() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Note[] notes = {new Note(6),new Note(12)};
		Chord a2 = new ChordGeneric(notes);
		Assert.assertFalse(ParallelFifths.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testNull(){
		Assert.assertTrue(ParallelFifths.getInstance().correctJoining(null, null));
	}
}
