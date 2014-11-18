package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.Trichord6;

import org.junit.Test;

public class Trichord6Tests {

	@Test
	public void testMajor6_top3_double3(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Third,ChordPosition.Third,true);
		Note[] notes = {new Note(53),new Note(44),new Note(37),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_top3_double3_minor(){
		Chord tc = new Trichord6(Tonality.CMinor,ScaleDegree.Tonic,Alteration.Minor,
				new Note(29),ChordPosition.Third,ChordPosition.Third,true);
		Note[] notes = {new Note(52),new Note(44),new Note(37),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_top3_double3_augmented(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Augmented,
				new Note(29),ChordPosition.Third,ChordPosition.Third,true);
		Note[] notes = {new Note(53),new Note(45),new Note(37),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_top3_double3_diminished(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Diminished,
				new Note(29),ChordPosition.Third,ChordPosition.Third,true);
		Note[] notes = {new Note(52),new Note(43),new Note(37),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_top5_double1_minor(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Minor,
				new Note(29),ChordPosition.Fifth,ChordPosition.Prime,true);
		Note[] notes = {new Note(56),new Note(49),new Note(37),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_top5_double3_augmented(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Augmented,
				new Note(29),ChordPosition.Fifth,ChordPosition.Third,true);
		Note[] notes = {new Note(57),new Note(49),new Note(41),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_top5_double5_major_noUnison(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Fifth,ChordPosition.Fifth,false,true);
		Note[] notes = {new Note(44),new Note(37),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor6_to3_double3_major(){
		Chord tc = new Trichord6(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Third,ChordPosition.Third,true);
		Note[] notes = {new Note(53),new Note(44),new Note(37),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	

}
