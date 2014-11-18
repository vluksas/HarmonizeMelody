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

public class AllVoicesDownTests {
	@Test
	public void testCorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectD5();
		cs.lowerOct();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a2 = cs.buildChord();
		Assert.assertTrue(AllVoicesDown.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testCorrectJoiningSameChord() {
		ChordSelector cs = new ChordSelector();
		cs.selectK64();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a1 = cs.buildChord();
		Chord a2 = cs.buildChord();
		Assert.assertTrue(AllVoicesDown.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testIncorrectJoining() {
		ChordSelector cs = new ChordSelector();
		Chord a1 = cs.buildChord();
		cs.selectOct(1);
		cs.selectD5();
		Chord a2 = cs.buildChord();
		Assert.assertFalse(AllVoicesDown.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testAllButOneDown() {
		ChordSelector cs = new ChordSelector();
		cs.selectD5();
		cs.lowerOct();
		cs.selectTopPos(ChordPosition.Fifth);
		Chord a1 = cs.buildChord();
		cs.reset();
		Chord a2 = cs.buildChord();
		Assert.assertTrue(AllVoicesDown.getInstance().correctJoining(a1, a2));
	}
	@Test
	public void testNull(){
		Assert.assertTrue(AllVoicesDown.getInstance().correctJoining(null, null));
	}
}
