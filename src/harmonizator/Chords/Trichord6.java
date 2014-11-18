package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class Trichord6 extends Trichord{

	public Trichord6(Tonality t, ScaleDegree scDeg, Alteration alt, Note base,
			ChordPosition top, ChordPosition doubled, boolean isWide) {
		this.tonality = t;
		this.scDeg = scDeg;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		makeTrichord(alt,top,doubled,isWide,false);
	}
	
	public Trichord6(Tonality t, ScaleDegree scDeg, Alteration alt, Note base,
			ChordPosition top, ChordPosition doubled, boolean isWide, boolean forceNoUnison) {
		this.tonality = t;
		this.scDeg = scDeg;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		makeTrichord(alt,top,doubled,isWide, forceNoUnison);
	}
	
	private void makeTrichord(Alteration alt,ChordPosition top,ChordPosition doubled,boolean isWide , boolean forceNoUnison){
		if(top == ChordPosition.Seventh){
			top = ChordPosition.Prime;
		}
		if((top == ChordPosition.Third && doubled != ChordPosition.Third)){//Incorrect data
			notes = null;
			numOfNotes = 0;
			return;
		}
		if(isWide){
			if(top == ChordPosition.Prime){
				if(doubled == ChordPosition.Prime){
					if(!forceNoUnison){
						notes[0] = new Note(notes[3].getId()+20);
						notes[1] = new Note(notes[3].getId()+8);
						notes[2] = new Note(notes[3].getId()+3);
					}else{
						notes[0] = new Note(notes[3].getId()+20);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+8);
					}
				}else if(doubled == ChordPosition.Third){
					notes[0] = new Note(notes[3].getId()+20);
					notes[1] = new Note(notes[3].getId()+12);
					notes[2] = new Note(notes[3].getId()+3);
				}else if(doubled == ChordPosition.Fifth){
					notes[0] = new Note(notes[3].getId()+20);
					notes[1] = new Note(notes[3].getId()+15);
					notes[2] = new Note(notes[3].getId()+3);
				}
			}else if(top == ChordPosition.Third){
				notes[0] = new Note(notes[3].getId()+24);
				notes[1] = new Note(notes[3].getId()+15);
				notes[2] = new Note(notes[3].getId()+8);
			}else if(top == ChordPosition.Fifth){
				if(doubled == ChordPosition.Prime){
					notes[0] = new Note(notes[3].getId()+27);
					notes[1] = new Note(notes[3].getId()+20);
					notes[2] = new Note(notes[3].getId()+8);
				}else if(doubled == ChordPosition.Third){
					notes[0] = new Note(notes[3].getId()+27);
					notes[1] = new Note(notes[3].getId()+20);
					notes[2] = new Note(notes[3].getId()+12);
				}else if(doubled == ChordPosition.Fifth){
					notes[0] = new Note(notes[3].getId()+27);
					notes[1] = new Note(notes[3].getId()+15);
					notes[2] = new Note(notes[3].getId()+8);
				}
			}
		}else{
			if(top == ChordPosition.Prime){
				if(doubled == ChordPosition.Prime){
					notes[0] = new Note(notes[3].getId()+8);
					notes[1] = new Note(notes[3].getId()+8);
					notes[2] = new Note(notes[3].getId()+3);
				}else if(doubled == ChordPosition.Third){
					notes[0] = new Note(notes[3].getId()+8);
					notes[1] = new Note(notes[3].getId()+3);
					notes[2] = new Note(notes[3].getId()+0);
				}else if(doubled == ChordPosition.Fifth){
					notes[0] = new Note(notes[3].getId()+8);
					notes[1] = new Note(notes[3].getId()+3);
					notes[2] = new Note(notes[3].getId()+3);
				}
			}else if(top == ChordPosition.Third){
					notes[0] = new Note(notes[3].getId()+12);
					notes[1] = new Note(notes[3].getId()+8);
					notes[2] = new Note(notes[3].getId()+3);
			}else if(top == ChordPosition.Fifth){
				if(doubled == ChordPosition.Prime){
					notes[0] = new Note(notes[3].getId()+15);
					notes[1] = new Note(notes[3].getId()+8);
					notes[2] = new Note(notes[3].getId()+8);
				}else if(doubled == ChordPosition.Third){
					notes[0] = new Note(notes[3].getId()+15);
					notes[1] = new Note(notes[3].getId()+12);
					notes[2] = new Note(notes[3].getId()+8);
				}else if(doubled == ChordPosition.Fifth){
					if(!forceNoUnison){
						notes[0] = new Note(notes[3].getId()+15);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+8);
					}else{
						notes[0] = new Note(notes[3].getId()+15);
						notes[1] = new Note(notes[3].getId()+8);
						notes[2] = new Note(notes[3].getId()+3);
					}
				}
			}
		}
		applyAlterations(alt);
	}
	
	@Override
	protected void applyAlterations(Alteration alt){
		for(Note n: notes){
			if((n.getId() - notes[3].getId())%12 == 0){
				applySingleAlteration(n,ChordPosition.Third,alt);
			}else if((n.getId() - notes[3].getId())%12 == 3){
				applySingleAlteration(n,ChordPosition.Fifth,alt);
			}
		}
	}
	

}
