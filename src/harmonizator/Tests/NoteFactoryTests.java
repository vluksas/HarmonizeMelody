package harmonizator.Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import harmonizator.Note;
import harmonizator.NoteFactory;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

import org.junit.Test;

public class NoteFactoryTests {

	@Test
	public void testDominant() {
		Note n = NoteFactory.getNote(0, Tonality.CsharpMajor, ScaleDegree.Dominant);
		assertEquals(n.getId(), 9);
	}
	@Test
	public void testTonic() {
		Note n = NoteFactory.getNote(1, Tonality.AflatMinor, ScaleDegree.Tonic);
		assertEquals(n.getId(), 21);
	}
	@Test
	public void testMediantMinor() {
		Note n = NoteFactory.getNote(1, Tonality.FMinor, ScaleDegree.Mediant);
		assertEquals(n.getId(), 21);
	}
	@Test
	public void testMediantMajor() {
		Note n = NoteFactory.getNote(1, Tonality.FMajor, ScaleDegree.Mediant);
		assertEquals(n.getId(), 22);
	}

}
