package harmonizator.Chord.Tests;

import static org.junit.Assert.*;
import harmonizator.Note;
import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.*;

import org.junit.Test;

public class TrichordFactoryTests {

	//Trichord (root poisition) tests:
	@Test
	public void testCmaj_T5_1_top3_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Tonic,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(53),new Note(44),new Note(37),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testCmin_T5_1_top3_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMinor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Tonic,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(44),new Note(37),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testDmin_II5_1_top1_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMinor,
				ChordPosition.Prime,ChordPosition.Prime,ScaleDegree.Supertonic,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(53),new Note(44),new Note(35),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testDmin_II5_1_top1_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMinor,
				ChordPosition.Prime,ChordPosition.Prime,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(41),new Note(35),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testDmin_II5_3_top3_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMinor,
				Scale.Melodic,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(36),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testDmaj_II5_3_top5_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMajor,
				Scale.Melodic,
				ChordPosition.Third,ChordPosition.Fifth,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(32),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testDmaj_II5_3_top5_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMajor,
				ChordPosition.Third,ChordPosition.Fifth,ScaleDegree.Supertonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(36),new Note(32),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testCmaj_II5_3_top5_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				Scale.Melodic,
				ChordPosition.Third,ChordPosition.Fifth,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(35),new Note(32),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testCmaj_II5_3_top5_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.CMajor,
				ChordPosition.Third,ChordPosition.Fifth,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(36),new Note(32),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testEflatMin_III5_3_top5_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMinor,
				ChordPosition.Third,ChordPosition.Fifth,ScaleDegree.Mediant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(50),new Note(47),new Note(35),new Note(31)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testEflatMin_III5_3_top5_wide_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMinor,
				Scale.Harmonic,
				ChordPosition.Third,ChordPosition.Fifth,ScaleDegree.Mediant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(51),new Note(47),new Note(35),new Note(31)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testEflatMin_S5_1_top5_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMinor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(48),new Note(45),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testEflatMin_S5_1_top5_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(49),new Note(45),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testEflatMaj_S5_1_top5_narrow_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMajor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(48),new Note(45),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testEflatMaj_S5_1_top5_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.EflatMajor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Subdominant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(49),new Note(45),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testGsharpMin_S5_3_top3_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.GsharpMinor,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(55),new Note(43),new Note(35),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testGsharpMin_S5_3_top3_wide_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.GsharpMinor,
				Scale.Harmonic,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(56),new Note(44),new Note(35),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testAflatMaj_S5_3_top3_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.AflatMajor,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(56),new Note(44),new Note(35),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void testAflatMaj_S5_3_top3_wide_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.AflatMajor,
				Scale.Melodic,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(55),new Note(43),new Note(35),new Note(28)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Hmin_S5_1_top3_wide_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.HMinor,
				Scale.Harmonic,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Submediant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(60),new Note(51),new Note(44),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Hmin_S5_1_top3_wide_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.HMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Submediant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(60),new Note(51),new Note(45),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Hmaj_S5_1_top5_wide_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.HMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Submediant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(44),new Note(36),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Hmaj_S5_1_top5_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.HMajor,
				ChordPosition.Prime,ChordPosition.Fifth,ScaleDegree.Submediant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(52),new Note(45),new Note(36),new Note(33)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Dmaj_S5_1_top3_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMajor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(41),new Note(38),new Note(32),new Note(26)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Dmaj_S5_1_top3_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMajor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(41),new Note(37),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Dmin_S5_1_top3_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMinor,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(41),new Note(37),new Note(32),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Dmin_S5_1_top3_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Prime,Tonality.DMinor,
				Scale.Melodic,
				ChordPosition.Prime,ChordPosition.Third,ScaleDegree.Subtonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(41),new Note(38),new Note(32),new Note(26)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	
	//--------------------------------------------------

	@Test
	public void Cmaj_S6_1_top3_wide() {
		ChordInfo ci = new ChordInfo(ChordPosition.Third,Tonality.CMajor,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Subtonic,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(51),new Note(42),new Note(36),new Note(27)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Cmin_S6_1_top3_wide_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Third,Tonality.CMinor,
				Scale.Melodic,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Subtonic,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(51),new Note(42),new Note(36),new Note(27)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Cmin_M6_1_top3_narrow_melodic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Third,Tonality.CMinor,
				Scale.Melodic,
				ChordPosition.Third,ChordPosition.Third,ScaleDegree.Mediant,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(44),new Note(40),new Note(36),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	
	//------------------------------------------------------
	@Test	
	public void Cmin_T64_top3_narrow() {
		ChordInfo ci = new ChordInfo(ChordPosition.Fifth,Tonality.CMinor,
				Scale.Natural,
				null,ChordPosition.Third,ScaleDegree.Tonic,
				2,false);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(40),new Note(37),new Note(32),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
	@Test
	public void Fmin_D64_top5_wide_harmonic() {
		ChordInfo ci = new ChordInfo(ChordPosition.Fifth,Tonality.FMinor,
				Scale.Harmonic,
				null,ChordPosition.Fifth,ScaleDegree.Dominant,
				2,true);
		ChordFactory cf = new TrichordFactory();
		Chord tc = cf.getChord(ci);
		Note[] notes = {new Note(56),new Note(49),new Note(41),new Note(32)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), tc.getNotes());
	}
}
