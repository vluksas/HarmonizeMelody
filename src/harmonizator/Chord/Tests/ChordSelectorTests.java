package harmonizator.Chord.Tests;

import static org.junit.Assert.*;

import harmonizator.Note;
import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordSelector;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordInfo;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.Trichord64;

import org.junit.Test;

public class ChordSelectorTests {
	@Test 
	public void testTonalityConstructor(){
		ChordSelector cb = new ChordSelector(Tonality.FsharpMinor);
		cb.selectD5();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(50),new Note(45),new Note(42),new Note(38)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testT5(){
		ChordSelector cb = new ChordSelector();
		cb.selectT5();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(49),new Note(44),new Note(41),new Note(37)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testT6(){
		ChordSelector cb = new ChordSelector();
		cb.selectT6();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(49),new Note(49),new Note(44),new Note(41)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testT64(){
		ChordSelector cb = new ChordSelector();
		cb.selectT64();
		cb.selectLayout(false, ChordPosition.Fifth);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(53),new Note(49),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testK64(){
		ChordSelector cb = new ChordSelector();
		cb.selectK64();
		cb.selectLayout(false, ChordPosition.Fifth);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(53),new Note(49),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
		assertEquals(true, ((Trichord64)result).isCadential());
	}
	@Test
	public void testT64_fromK64(){
		ChordSelector cb = new ChordSelector();
		cb.selectK64();
		cb.selectLayout(false, ChordPosition.Fifth);
		cb.selectNonCadential();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(53),new Note(49),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
		assertEquals(false, ((Trichord64)result).isCadential());
	}
	@Test
	public void testS5(){
		ChordSelector cb = new ChordSelector();
		cb.selectS5();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(49),new Note(46),new Note(42)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testS6(){
		ChordSelector cb = new ChordSelector();
		cb.selectS6();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(54),new Note(49),new Note(46)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testS64(){
		ChordSelector cb = new ChordSelector();
		cb.selectS64();
		cb.selectLayout(false, ChordPosition.Fifth);
		cb.selectTonality(Tonality.GMajor);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(53),new Note(49),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testTrichord_Tetrachord_shuffle(){
		ChordSelector cb = new ChordSelector();
		cb.selectD7();
		cb.selectS64();
		cb.selectLayout(false, ChordPosition.Fifth);
		cb.selectTonality(Tonality.GMajor);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(53),new Note(49),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testD5(){
		ChordSelector cb = new ChordSelector();
		cb.selectD5();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(51),new Note(48),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testD6(){
		ChordSelector cb = new ChordSelector();
		cb.selectD6();
		cb.selectTonality(Tonality.FMajor);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(49),new Note(49),new Note(44),new Note(41)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testD64(){
		ChordSelector cb = new ChordSelector(Tonality.FMinor);
		cb.selectD64();
		cb.selectLayout(false, ChordPosition.Fifth);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(53),new Note(49),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testD7(){
		ChordSelector cb = new ChordSelector();
		cb.selectD7();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(51),new Note(48),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testD56(){
		ChordSelector cb = new ChordSelector();
		cb.selectTopPos(ChordPosition.Third);
		cb.selectD56();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(66),new Note(56),new Note(51),new Note(48)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testD34(){
		ChordSelector cb = new ChordSelector();
		cb.selectTopPos(ChordPosition.Fifth);
		cb.selectD34();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(48),new Note(44),new Note(39)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testD2(){
		ChordSelector cb = new ChordSelector();
		cb.selectTopPos(ChordPosition.Seventh);
		cb.selectD2();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(51),new Note(48),new Note(42)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testII7(){
		ChordSelector cb = new ChordSelector();
		cb.selectII7();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(49),new Note(46),new Note(42),new Note(39)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testII56(){
		ChordSelector cb = new ChordSelector(Tonality.FMajor);
		cb.selectTopPos(ChordPosition.Third);
		cb.selectII56();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(66),new Note(56),new Note(51),new Note(47)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testII34(){
		ChordSelector cb = new ChordSelector(Tonality.FMajor);
		cb.selectTopPos(ChordPosition.Fifth);
		cb.selectII34();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(47),new Note(44),new Note(39)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testII2(){
		ChordSelector cb = new ChordSelector(Tonality.FMajor);
		cb.selectTopPos(ChordPosition.Seventh);
		cb.selectII2();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(51),new Note(47),new Note(42)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testVII7(){
		ChordSelector cb = new ChordSelector();
		cb.selectVII7();
		cb.selectScale(Scale.Harmonic);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(57),new Note(54),new Note(51),new Note(48)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testVII56(){
		ChordSelector cb = new ChordSelector(Tonality.AflatMajor);
		cb.selectTopPos(ChordPosition.Third);
		cb.selectVII56();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(66),new Note(56),new Note(50),new Note(47)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testVII34(){
		ChordSelector cb = new ChordSelector(Tonality.AflatMajor);
		cb.selectTopPos(ChordPosition.Fifth);
		cb.selectVII34();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(47),new Note(44),new Note(38)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testVII2(){
		ChordSelector cb = new ChordSelector(Tonality.AflatMajor);
		cb.selectTopPos(ChordPosition.Seventh);
		cb.selectVII2();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(56),new Note(50),new Note(47),new Note(42)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testSelectOct_nonsenical(){
		ChordSelector cb = new ChordSelector();
		cb.selectT5();
		cb.selectOct(-666);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(49),new Note(44),new Note(41),new Note(37)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testSelectOct_working(){
		ChordSelector cb = new ChordSelector();
		cb.selectT5();
		cb.selectOct(2);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(37),new Note(32),new Note(29),new Note(25)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testSelectLayout(){
		ChordSelector cb = new ChordSelector();
		cb.selectD7();
		cb.selectLayout(true, ChordPosition.Third);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(72),new Note(63),new Note(54),new Note(44)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
	}
	@Test
	public void testSelectTonality(){
		ChordSelector cb = new ChordSelector();
		cb.selectD5();
		cb.selectTonality(Tonality.DMajor);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(58),new Note(53),new Note(50),new Note(46)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testSelectTonality_withScaleChange(){
		ChordSelector cb = new ChordSelector();
		cb.selectD5();
		cb.selectTonality(Tonality.DMinor,false);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(58),new Note(53),new Note(50),new Note(46)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testBuildChordDataGetter(){
		ChordSelector cb = new ChordSelector(Tonality.CMajor,Scale.Melodic);
		ChordInfo ci = cb.getChordToBuildData();
		assertEquals(ci.getScale(),Scale.Melodic);
	}
	@Test
	public void testWidnessSelection(){
		ChordSelector cb = new ChordSelector();
		cb.selectT5();
		cb.selectWide();		
		Chord result = cb.buildChord();
		Note[] notes1 = {new Note(61),new Note(53),new Note(44),new Note(37)};
		Note[] notes2 = {new Note(49),new Note(44),new Note(41),new Note(37)};
		Chord expected = new ChordGeneric(notes1);
		assertEquals(expected,result);
		cb.selectNarrow();
		expected = new ChordGeneric(notes2);
		result = cb.buildChord();
		assertEquals(expected,result);
		
	}
	@Test
	public void testSelectScaleDegree_enum(){
		ChordSelector cb = new ChordSelector();
		cb.selectScaleDegree(ScaleDegree.Subdominant);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(54),new Note(49),new Note(46),new Note(42)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}
	@Test
	public void testForceUnison(){
		ChordSelector cb = new ChordSelector();
		cb.selectT6();
		cb.selectOct(2);
		cb.selectDoubledPos(ChordPosition.Fifth);
		cb.selectTopPos(ChordPosition.Fifth);
		cb.selectUnisonPrefered();
		Chord result = cb.buildChord();
		Note[] notes = {new Note(44),new Note(37),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
		cb.selectNoUnisonPrefered();
		result = cb.buildChord();
		Note[] notes1 = {new Note(44),new Note(44),new Note(37),new Note(29)};
		expected = new ChordGeneric(notes1);
		assertEquals(expected, result);
	}
	@Test
	public void testForceUnison_directSet(){
		ChordSelector cb = new ChordSelector();
		cb.selectT6();
		cb.selectOct(2);
		cb.selectDoubledPos(ChordPosition.Fifth);
		cb.selectTopPos(ChordPosition.Fifth);
		cb.selectNoUnisonOpt(true);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(44),new Note(37),new Note(32),new Note(29)};
		Chord expected = new ChordGeneric(notes);
		assertEquals(expected, result);
		cb.selectNoUnisonOpt(false);
		result = cb.buildChord();
		Note[] notes1 = {new Note(44),new Note(44),new Note(37),new Note(29)};
		expected = new ChordGeneric(notes1);
		assertEquals(expected, result);
	}
	
	@Test
	public void complexFunctionalityTest(){
		ChordSelector cb = new ChordSelector(Tonality.CMajor,Scale.Melodic);
		cb.selectScaleDegree(5);
		cb.selectTonality(Tonality.DMajor,false);
		Chord result = cb.buildChord();
		Note[] notes = {new Note(58),new Note(53),new Note(50),new Note(46)};
		Chord expected = new ChordGeneric(notes);
		assertArrayEquals(expected.getNotes(), result.getNotes());
	}

}
