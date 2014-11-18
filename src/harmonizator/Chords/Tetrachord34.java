package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class Tetrachord34 extends Tetrachord{
	
	public Tetrachord34(Tonality tonality, ScaleDegree scDegree,
			Alteration alteration, Note base, ChordPosition topPos, boolean wide) {
		this.tonality = tonality;
		this.scDeg = scDegree;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		notePositions = new ChordPosition[4];
		notePositions[3] = ChordPosition.Fifth;
		notePositions[0] = topPos;
		makeTetrachord(alteration,topPos,wide);
	}
	
	private void makeTetrachord(Alteration alt,ChordPosition top,boolean isWide){
		if(top == ChordPosition.Fifth){//Bad options selected
			notes = null;
			numOfNotes = 0;
			return;
		}
		if(isWide){
			if(top == ChordPosition.Prime){
				notes[0] = new Note(notes[3].getId()+17);
				notes[1] = new Note(notes[3].getId()+16);
				notePositions[1] = ChordPosition.Seventh;
				notes[2] = new Note(notes[3].getId()+9);
				notePositions[2] = ChordPosition.Third;
			}else if(top == ChordPosition.Third){
				notes[0] = new Note(notes[3].getId()+21);
				notes[1] = new Note(notes[3].getId()+16);
				notePositions[1] = ChordPosition.Seventh;
				notes[2] = new Note(notes[3].getId()+5);
				notePositions[2] = ChordPosition.Prime;
			}else if(top == ChordPosition.Seventh){
				notes[0] = new Note(notes[3].getId()+28);
				notes[1] = new Note(notes[3].getId()+17);
				notePositions[1] = ChordPosition.Prime;
				notes[2] = new Note(notes[3].getId()+9);
				notePositions[2] = ChordPosition.Third;
			}
		}else{
			if(top == ChordPosition.Prime){
				notes[0] = new Note(notes[3].getId()+17);
				notes[1] = new Note(notes[3].getId()+9);
				notePositions[1] = ChordPosition.Third;
				notes[2] = new Note(notes[3].getId()+4);
				notePositions[2] = ChordPosition.Seventh;
			}else if(top == ChordPosition.Third){
				notes[0] = new Note(notes[3].getId()+9);
				notes[1] = new Note(notes[3].getId()+5);
				notePositions[1] = ChordPosition.Prime;
				notes[2] = new Note(notes[3].getId()+4);
				notePositions[2] = ChordPosition.Seventh;
			}else if(top == ChordPosition.Seventh){
				notes[0] = new Note(notes[3].getId()+16);
				notes[1] = new Note(notes[3].getId()+9);
				notePositions[1] = ChordPosition.Third;
				notes[2] = new Note(notes[3].getId()+5);
				notePositions[2] = ChordPosition.Prime;
			}
		}
		applyAlteration(alt);
	}
	
	protected int getNoteIndexByPosition(ChordPosition pos){
		if(pos == ChordPosition.Fifth){
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
