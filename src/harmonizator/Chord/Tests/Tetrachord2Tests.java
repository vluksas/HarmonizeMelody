package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.Tetrachord2;
import org.junit.Test;

public class Tetrachord2Tests {


	@Test
	public void testMajor2_top1_wide(){
		Chord tc = new Tetrachord2(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(36),ChordPosition.Prime,true);
		Note[] notes = {new Note(61),new Note(53),new Note(44),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor2_top1_narrow(){
		Chord tc = new Tetrachord2(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(36),ChordPosition.Prime,false);
		Note[] notes = {new Note(49),new Note(44),new Note(41),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor2_top5_wide(){
		Chord tc = new Tetrachord2(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(36),ChordPosition.Fifth,true);
		Note[] notes = {new Note(56),new Note(49),new Note(41),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor2_top5_narrow(){
		Chord tc = new Tetrachord2(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(36),ChordPosition.Fifth,false);
		Note[] notes = {new Note(44),new Note(41),new Note(37),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
	@Test
	public void testMajor2_top3_wide(){
		Chord tc = new Tetrachord2(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(36),ChordPosition.Third,true);
		Note[] notes = {new Note(53),new Note(44),new Note(37),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}	
	@Test
	public void testMajor2_top3_narrow(){
		Chord tc = new Tetrachord2(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(36),ChordPosition.Third,false);
		Note[] notes = {new Note(53),new Note(49),new Note(44),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}

}
