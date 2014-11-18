package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class Tetrachord extends ChordGeneric {
	protected Tonality tonality = null;
	protected ChordPosition[] notePositions;
	
	public Tetrachord(){
		
	}
	
	public Tetrachord(Note n) {
		this.numOfNotes = 4;
		int nId = n.getId();
		notes = new Note[4];
		notes[3] = n;
		if(nId > 10){
			notes[2] = new Note(nId + 4);
			notes[1] = new Note(nId + 7);
			notes[0] = new Note(nId + 10);
		}else{
			for(int i = 0;i < this.numOfNotes-1;i++){
				notes[i] = n;
			}
		}
		notePositions = new ChordPosition[4];
		notePositions[3] = ChordPosition.Prime;
		notePositions[2] = ChordPosition.Third;
		notePositions[1] = ChordPosition.Fifth;
		notePositions[0] = ChordPosition.Seventh;
	}

	public Tetrachord(Tonality tonality, ScaleDegree scDegree,
			Alteration alteration, Note base, ChordPosition topPos, boolean wide) {
		this.tonality = tonality;
		this.scDeg = scDegree;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		notePositions = new ChordPosition[4];
		notePositions[3] = ChordPosition.Prime;
		notePositions[0] = topPos;
		makeTetrachord(alteration,topPos,wide);
	}
	
	private void makeTetrachord(Alteration alt,ChordPosition top,boolean isWide){
		if(top == ChordPosition.Prime){//Bad options selected
			notes = null;
			numOfNotes = 0;
			return;
		}
		if(isWide){
			if(top == ChordPosition.Third){
				notes[0] = new Note(notes[3].getId()+28);
				notes[1] = new Note(notes[3].getId()+19);
				notePositions[1] = ChordPosition.Fifth;
				notes[2] = new Note(notes[3].getId()+11);
				notePositions[2] = ChordPosition.Seventh;
			}else if(top == ChordPosition.Fifth){
				notes[0] = new Note(notes[3].getId()+19);
				notes[1] = new Note(notes[3].getId()+11);
				notePositions[1] = ChordPosition.Seventh;
				notes[2] = new Note(notes[3].getId()+4);
				notePositions[2] = ChordPosition.Third;
			}else if(top == ChordPosition.Seventh){
				notes[0] = new Note(notes[3].getId()+23);
				notes[1] = new Note(notes[3].getId()+16);
				notePositions[1] = ChordPosition.Third;
				notes[2] = new Note(notes[3].getId()+7);
				notePositions[2] = ChordPosition.Fifth;
			}
		}else{
			if(top == ChordPosition.Third){
				notes[0] = new Note(notes[3].getId()+16);
				notes[1] = new Note(notes[3].getId()+11);
				notePositions[1] = ChordPosition.Seventh;
				notes[2] = new Note(notes[3].getId()+7);
				notePositions[2] = ChordPosition.Fifth;
			}else if(top == ChordPosition.Fifth){
				notes[0] = new Note(notes[3].getId()+19);
				notes[1] = new Note(notes[3].getId()+16);
				notePositions[1] = ChordPosition.Third;
				notes[2] = new Note(notes[3].getId()+11);
				notePositions[2] = ChordPosition.Seventh;
			}else if(top == ChordPosition.Seventh){
				notes[0] = new Note(notes[3].getId()+11);
				notes[1] = new Note(notes[3].getId()+7);
				notePositions[1] = ChordPosition.Fifth;
				notes[2] = new Note(notes[3].getId()+4);
				notePositions[2] = ChordPosition.Third;
			}
		}
		applyAlteration(alt);
	}
	
	protected void applyAlteration(Alteration alt){
		int seventhInd = getNoteIndexByPosition(ChordPosition.Seventh);
		int fifthInd = getNoteIndexByPosition(ChordPosition.Fifth);
		int thirdInd = getNoteIndexByPosition(ChordPosition.Third);
		switch(alt){
		case Augmented:
			notes[fifthInd].incrementId(1);
			notes[seventhInd].incrementId(-1);
			break;
		case AugmentedMajor:
			notes[fifthInd].incrementId(1);
			break;
		case Diminished:
			notes[thirdInd].incrementId(-1);
			notes[fifthInd].incrementId(-1);
			notes[seventhInd].incrementId(-2);
			break;
		case Dominant:
			notes[seventhInd].incrementId(-1);
			break;
		case HalfDiminished:
			notes[thirdInd].incrementId(-1);
			notes[fifthInd].incrementId(-1);
			notes[seventhInd].incrementId(-1);
			break;
		case Major:
			break;
		case Minor:
			notes[thirdInd].incrementId(-1);
			notes[seventhInd].incrementId(-1);
			break;
		case MinorMajor:
			notes[thirdInd].incrementId(-1);
			break;
		default:
			break;
		
		}
	}
	
	protected int getNoteIndexByPosition(ChordPosition pos){
		if(pos == ChordPosition.Prime){
			return 3;
		}
		for(int i = 0;i < notePositions.length;i++){
			if(notePositions[i] == pos){
				return i;
			}
		}
		return -1;//Inexistant position
	}
	
	public Tonality getTonality() {
		return tonality;
	}
	
	public ScaleDegree getScDeg() {
		return scDeg;
	}

	public ChordPosition[] getNotePositions() {
		return notePositions;
	}
	
	public int getSeventhIndex(){
		return getNoteIndexByPosition(ChordPosition.Seventh);
	}
	
	public void bassUp(){
		if(Note.distance(notes[3], notes[2]) >= 12){
			notes[3].incrementId(12);
		}
	}
	
	public void bassDown(){
		if(Note.distance(notes[3], notes[2]) <= 24){
			notes[3].incrementId(-12);
		}
	}

}
