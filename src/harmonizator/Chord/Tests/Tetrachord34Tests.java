package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.Tetrachord34;

import org.junit.Test;

public class Tetrachord34Tests {
 
	@Test
	public void test_top5_bad_input(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Fifth,true);
		assertNull(tc.getNotes());
	}	
	@Test
	public void testMajor34_top1_wide(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Prime,true);
		Note[] notes = {new Note(49),new Note(48),new Note(41),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor34_top1_narrow(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Prime,false);
		Note[] notes = {new Note(49),new Note(41),new Note(36),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor34_top7_wide(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Seventh,true);
		Note[] notes = {new Note(60),new Note(49),new Note(41),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor34_top7_narrow(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Seventh,false);
		Note[] notes = {new Note(48),new Note(41),new Note(37),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor34_top3_wide(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Third,true);
		Note[] notes = {new Note(53),new Note(48),new Note(37),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor34_top3_narrow(){
		Chord tc = new Tetrachord34(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(32),ChordPosition.Third,false);
		Note[] notes = {new Note(41),new Note(37),new Note(36),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}

}
