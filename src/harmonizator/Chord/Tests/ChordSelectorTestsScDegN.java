package harmonizator.Chord.Tests;

import static org.junit.Assert.assertEquals;
import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordSelector;
import harmonizator.Chords.ChordGeneric;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class ChordSelectorTestsScDegN {
	   private Integer scaleDegree;
	   private ChordSelector chordSelector;
	   private Chord exChord;

	   @Before
	   public void initialize() {
		   chordSelector = new ChordSelector();
	   }

	   // Each parameter should be placed as an argument here
	   // Every time runner triggers, it will pass the arguments
	   // from parameters we defined in primeNumbers() method
	   public ChordSelectorTestsScDegN(Integer scDeg,Chord exNotes) {
	      this.scaleDegree = scDeg;
	      this.exChord = exNotes;
	   }

	   @Parameterized.Parameters
	   public static Collection<Object[]> scDegrees() {
		   Note[] n1 = {new Note(49),new Note(44),new Note(41),new Note(37)};
		   Note[] n2 = {new Note(51),new Note(46),new Note(42),new Note(39)};
		   Note[] n3 = {new Note(53),new Note(48),new Note(44),new Note(41)};
		   Note[] n4 = {new Note(54),new Note(49),new Note(46),new Note(42)};
		   Note[] n5 = {new Note(56),new Note(51),new Note(48),new Note(44)};
		   Note[] n6 = {new Note(58),new Note(53),new Note(49),new Note(46)};
		   Note[] n7 = {new Note(60),new Note(54),new Note(51),new Note(48)};
	      return Arrays.asList(new Object[][] {
	 	     {0, new ChordGeneric(n1)},
	         {1, new ChordGeneric(n1)},
	         {2, new ChordGeneric(n2)},
	         {3, new ChordGeneric(n3)},
	         {4, new ChordGeneric(n4)},
	         {5, new ChordGeneric(n5)},
	         {6, new ChordGeneric(n6)},
	         {7, new ChordGeneric(n7)},
	         {8, new ChordGeneric(n1)}
	      });
	   }
		@Test
		public void testSelectScaleDegree_numeric(){
			chordSelector.selectScaleDegree(scaleDegree);
			Chord result = chordSelector.buildChord();
			assertEquals(exChord, result);
		}
}
