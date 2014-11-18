package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Note;
import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordFactory;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordInfo;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.TetrachordFactory;

import org.junit.Test;

public class TetrachordFactoryTests {

	@Test
	public void testTonic_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Tonic,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(53),new Note(44),new Note(36),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		/*System.out.println(tc);
		System.out.println(expected);*/
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testTonic_maj_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Tonic,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(53),new Note(44),new Note(35),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testTonic_min_nonNatural() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMinor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Tonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(40),new Note(36),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testTonic_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMinor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Tonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(40),new Note(35),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testII_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.BMajor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(32),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testII_maj_nonNatural() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.BMajor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(31),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testII_min_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.BMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(32),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testII_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.BMinor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(31),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testIII_maj_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.AflatMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(31),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testIII_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.AflatMajor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(32),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testIII_min_nonNatural() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.AMinor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(36),new Note(33),new Note(29),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testIII_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.AMinor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(36),new Note(32),new Note(29),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testS_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.GMajor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(36),new Note(29),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testS_maj_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.GMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(36),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testS_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.GMinor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(35),new Note(28),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testS_min_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.GMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(35),new Note(29),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testD_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.FMajor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(47),new Note(41),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testD_maj_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.FMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(47),new Note(40),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testD_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.FMinor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(47),new Note(40),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testD_min_nonNatural() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.FMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(47),new Note(41),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVI_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMajor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Submediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(40),new Note(35),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVI_maj_nonNatural() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Submediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(45),new Note(41),new Note(36),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVI_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EMinor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Submediant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(41),new Note(36),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVI_min_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Submediant,
				3,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(55),new Note(52),new Note(47),new Note(37)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVII_maj() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(46),new Note(42),new Note(39),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVII_maj_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(45),new Note(42),new Note(39),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVII_maj_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(45),new Note(42),new Note(39),new Note(35)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVII_min_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(46),new Note(42),new Note(39),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVII_min_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMinor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(45),new Note(42),new Note(39),new Note(36)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testVII_min() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMinor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(45),new Note(42),new Note(39),new Note(35)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}

	@Test
	public void test56_1() {
		ChordInfo ci = new ChordInfo(ChordPosition.Third,Tonality.CMajor,
				ChordPosition.Prime,ChordPosition.Prime,ScaleDegree.Tonic,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(49),new Note(44),new Note(36),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void test56_2() {
		ChordInfo ci = new ChordInfo(ChordPosition.Third,Tonality.CMajor,
				ChordPosition.Prime,ChordPosition.Seventh,ScaleDegree.Tonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(48),new Note(37),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	
	//---------------------------------------
	@Test
	public void test34_1() {
		ChordInfo ci = new ChordInfo(ChordPosition.Fifth,Tonality.FMajor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(53),new Note(47),new Note(37),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void test34_2() {
		ChordInfo ci = new ChordInfo(ChordPosition.Fifth,Tonality.CsharpMinor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Prime,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(49),new Note(40),new Note(34),new Note(31)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	//----------------------------------------------------------------
	@Test
	public void test2_1() {
		ChordInfo ci = new ChordInfo(ChordPosition.Seventh,Tonality.FMajor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Dominant,
				2,false);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(41),new Note(37),new Note(35)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void test2_2() {
		ChordInfo ci = new ChordInfo(ChordPosition.Seventh,Tonality.EMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Prime,ScaleDegree.Subtonic,
				2,true);
		ChordFactory cf = new TetrachordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(51),new Note(43),new Note(34),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, tc);
	}
}
