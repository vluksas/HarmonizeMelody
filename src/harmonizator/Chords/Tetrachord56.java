package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class Tetrachord56 extends Tetrachord{
	
	public Tetrachord56(Tonality tonality, ScaleDegree scDegree,
			Alteration alteration, Note base, ChordPosition topPos, boolean wide) {
		this.tonality = tonality;
		this.scDeg = scDegree;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		notePositions = new ChordPosition[4];
		notePositions[3] = ChordPosition.Third;
		notePositions[0] = topPos;
		makeTetrachord(alteration,topPos,wide);
	}
	
	private void makeTetrachord(Alteration alt,ChordPosition top,boolean isWide){
		if(top == ChordPosition.Third){//Bad options selected
			notes = null;
			numOfNotes = 0;
			return;
		}
		if(isWide){
			if(top == ChordPosition.Prime){
				notes[0] = new Note(notes[3].getId()+20);
				notes[1] = new Note(notes[3].getId()+15);
				notePositions[1] = ChordPosition.Fifth;
				notes[2] = new Note(notes[3].getId()+7);
				notePositions[2] = ChordPosition.Seventh;
			}else if(top == ChordPosition.Fifth){
				notes[0] = new Note(notes[3].getId()+27);
				notes[1] = new Note(notes[3].getId()+19);
				notePositions[1] = ChordPosition.Seventh;
				notes[2] = new Note(notes[3].getId()+8);
				notePositions[2] = ChordPosition.Prime;
			}else if(top == ChordPosition.Seventh){
				notes[0] = new Note(notes[3].getId()+19);
				notes[1] = new Note(notes[3].getId()+15);
				notePositions[1] = ChordPosition.Fifth;
				notes[2] = new Note(notes[3].getId()+8);
				notePositions[2] = ChordPosition.Prime;
			}
		}else{
			if(top == ChordPosition.Prime){
				notes[0] = new Note(notes[3].getId()+8);
				notes[1] = new Note(notes[3].getId()+7);
				notePositions[1] = ChordPosition.Seventh;
				notes[2] = new Note(notes[3].getId()+3);
				notePositions[2] = ChordPosition.Fifth;
			}else if(top == ChordPosition.Fifth){
				notes[0] = new Note(notes[3].getId()+15);
				notes[1] = new Note(notes[3].getId()+8);
				notePositions[1] = ChordPosition.Prime;
				notes[2] = new Note(notes[3].getId()+7);
				notePositions[2] = ChordPosition.Seventh;
			}else if(top == ChordPosition.Seventh){
				notes[0] = new Note(notes[3].getId()+19);
				notes[1] = new Note(notes[3].getId()+8);
				notePositions[1] = ChordPosition.Prime;
				notes[2] = new Note(notes[3].getId()+3);
				notePositions[2] = ChordPosition.Fifth;
			}
		}
		applyAlteration(alt);
	}
	
	protected int getNoteIndexByPosition(ChordPosition pos){
		if(pos == ChordPosition.Third){
			return 3;
		}
		for(int i = 0;i < notePositions.length;i++){
			if(notePositions[i] == pos){
				return i;
			}
		}
		return -1;//Inexistant position
	}
}
