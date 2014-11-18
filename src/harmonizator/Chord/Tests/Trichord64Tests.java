package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.Trichord64;

import org.junit.Test;

public class Trichord64Tests {

	@Test
	public void testMajor64_top1_wide(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Prime,true);
		Note[] notes = {new Note(61),new Note(53),new Note(44),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor64_top1_narrow_diminished(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Diminished,
				new Note(32),ChordPosition.Prime,false);
		Note[] notes = {new Note(49),new Note(43),new Note(40),new Note(31)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor64_top3_wide_augmented(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Augmented,
				new Note(32),ChordPosition.Third,true);
		Note[] notes = {new Note(53),new Note(45),new Note(37),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor64_top3_narrow_minor(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Minor,
				new Note(32),ChordPosition.Third,false);
		Note[] notes = {new Note(40),new Note(37),new Note(32),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor64_top5_wide(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Fifth,true);
		Note[] notes = {new Note(56),new Note(49),new Note(41),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor64_top5_narrow(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Fifth,false);
		Note[] notes = {new Note(44),new Note(41),new Note(37),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor64_top5_narrow_cadential(){
		Chord tc = new Trichord64(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Fifth,false,true);
		Note[] notes = {new Note(44),new Note(41),new Note(37),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
		assertEquals(true,((Trichord64)tc).isCadential());
	}

}
