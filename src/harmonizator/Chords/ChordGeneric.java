package harmonizator.Chords;

import java.util.Arrays;

import harmonizator.Note;
import harmonizator.ScaleDegree;

public class ChordGeneric implements Chord{
	public static final int TOP_CHORD_INDEX = 0;
	public static final int BOTTOM_CHORD_INDEX = 3;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(notes);
		result = prime * result + numOfNotes;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*if (getClass() != obj.getClass())
			return false;*/
		ChordGeneric other = (ChordGeneric) obj;
		if (!Arrays.equals(notes, other.notes))
			return false;
		if (numOfNotes != other.numOfNotes)
			return false;
		return true;
	}
	
	protected Note[] notes;
	protected int numOfNotes;
	protected ScaleDegree scDeg = null;
	
	public int getNumOfNotes() {
		return numOfNotes;
	}
	
	public ChordGeneric(){
	}
	
	public ChordGeneric(Note n){
		numOfNotes = 4;
		int nId = n.getId();
		notes = new Note[4];
		notes[0] = n;
		if(nId > 12){
			notes[1] = new Note(nId - 5);
			notes[2] = new Note(nId - 8);
			notes[3] = new Note(nId - 12);
		}else{
			for(int i = 1;i < 4;i++){
				notes[i] = n;
			}
		}
		
		
	}
	
	public ChordGeneric(Note[] notes){
		this.notes = notes;
		this.numOfNotes = notes.length;
	}
	
	public Note getNote(int number){
		if(number >= 0 && number < numOfNotes){
			return notes[number];
		}else{
			return null;
		}
	}
	
	public String toString(){
		String result = "";
		if(notes == null){
			return "";
		}
		for(Note n: notes){
			result += n.getNoteLetterName() + Integer.toString(n.getOctNameNumeric()) + ";";
		}
		return result;
	}
	
	@Override
	public Note[] getNotes() {
		return notes;
	}
	
	@Override
	public ScaleDegree getScDeg() {
		// TODO Auto-generated method stub
		return scDeg;
	}
	
	public void octaveUp(){
		for(Note n:notes){
			n.incrementId(12);
		}
	}
	
	public void octaveDown(){
		for(Note n:notes){
			n.incrementId(-12);
		}
	}
	
	public void bassUp(){
		notes[getNumOfNotes()-1].incrementId(12);
	}
	
	public void bassDown(){
		notes[getNumOfNotes()-1].incrementId(-12);
	}
}
