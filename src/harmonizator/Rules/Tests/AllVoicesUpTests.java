package harmonizator.Rules.Tests;


import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Rules.AllVoicesDown;
import harmonizator.Rules.AllVoicesUp;
import harmonizator.Rules.ParallelFifths;
import harmonizator.Rules.ParallelOctaves;

import org.junit.Assert;
import org.junit.Test;

public class AllVoicesUpTests {
	@Test
	public void testCorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		cs.lowerOct();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a2 = cs.buildChord();
		Assert.assertTrue(AllVoicesUp.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testCorrectJoiningSameChord() {
		ChordSelector cs = new ChordSelector();
		cs.selectK64();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a1 = cs.buildChord();
		Chord a2 = cs.buildChord();
		Assert.assertTrue(AllVoicesUp.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testIncorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Chord a2 = cs.buildChord();
		Assert.assertFalse(AllVoicesUp.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testAllButOneUp() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		Chord a2 = cs.buildChord();
		a2.bassDown();
		Assert.assertTrue(AllVoicesUp.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testNull(){
		Assert.assertTrue(AllVoicesUp.getInstance().correctJoining(null, null));
	}
}
