package harmonizator.Chords;

import harmonizator.Note;
import harmonizator.ScaleDegree;

public interface Chord {
	public int getNumOfNotes();
	public Note getNote(int Number);
	public Note[] getNotes();
	public String toString();
	public ScaleDegree getScDeg();
	public void octaveUp();
	public void octaveDown();
	public void bassUp();
	public void bassDown();
}
