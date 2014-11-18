package harmonizator.Tests;

import static org.junit.Assert.*;
import harmonizator.Note;
import harmonizator.ScaleDegree;

import org.junit.Test;

public class NoteTests {

	@Test
	public void testGettingScaleDegree1() {
		ScaleDegree scDeg = Note.getScaleDegree(new Note(17), new Note(13));
		assertEquals(ScaleDegree.Mediant,scDeg);
	}
	@Test
	public void testGettingScaleDegree2() {
		ScaleDegree scDeg = Note.getScaleDegree(new Note(21), new Note(13));
		assertEquals(ScaleDegree.Submediant,scDeg);
	}
	@Test
	public void testGettingScaleDegreeHigherTonic() {
		ScaleDegree scDeg = Note.getScaleDegree(new Note(1), new Note(11));
		assertEquals(ScaleDegree.Supertonic,scDeg);
	}

}
