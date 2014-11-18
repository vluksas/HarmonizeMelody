package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.Tetrachord56;

import org.junit.Test;

public class Tetrachord56Tests {

	@Test
	public void testMajor56_top1_wide(){
		Chord tc = new Tetrachord56(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Prime,true);
		Note[] notes = {new Note(49),new Note(44),new Note(36),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor56_top1_narrow(){
		Chord tc = new Tetrachord56(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Prime,false);
		Note[] notes = {new Note(37),new Note(36),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor56_top7_wide(){
		Chord tc = new Tetrachord56(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Seventh,true);
		Note[] notes = {new Note(48),new Note(44),new Note(37),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor56_top7_narrow(){
		Chord tc = new Tetrachord56(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Seventh,false);
		Note[] notes = {new Note(48),new Note(37),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor56_top5_wide(){
		Chord tc = new Tetrachord56(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Fifth,true);
		Note[] notes = {new Note(56),new Note(48),new Note(37),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor56_top5_narrow(){
		Chord tc = new Tetrachord56(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(29),ChordPosition.Fifth,false);
		Note[] notes = {new Note(44),new Note(37),new Note(36),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}

}
