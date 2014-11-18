package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class Trichord extends ChordGeneric {
	protected Tonality tonality = null;
	public Trichord(){
		
	}
	
	public Trichord(Note n) {
		super(n);
	}
	
	public Trichord(Tonality t,ScaleDegree scDeg,Alteration alt,
			Note base,ChordPosition top,ChordPosition doubled,boolean isWide){
		//isWide - defines whether use wide of narrow setup of the chord
		this.tonality = t;
		this.scDeg = scDeg;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		makeTrichord(alt,top,doubled,isWide);
	}
	
	private void makeTrichord(Alteration alt,ChordPosition top,ChordPosition doubled,boolean isWide){
		if(top == ChordPosition.Seventh){
			top = ChordPosition.Prime;
		}
		if((top == ChordPosition.Prime && doubled != ChordPosition.Prime) ||
				doubled == ChordPosition.Fifth){//Incorrect data
			notes = null;
			numOfNotes = 0;
			return;
		}
		if(isWide){
			if(top == ChordPosition.Prime){
				if(doubled == ChordPosition.Prime){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+24);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+7);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+24);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+8);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+24);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+6);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+24);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+7);
						break;
					}
				}
			}else if(top == ChordPosition.Third){
				if(doubled == ChordPosition.Prime){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+27);
						notes[1] = new Note(notes[3].getId()+19);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+28);
						notes[1] = new Note(notes[3].getId()+20);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+27);
						notes[1] = new Note(notes[3].getId()+18);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+28);
						notes[1] = new Note(notes[3].getId()+19);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					}
				}
				if(doubled == ChordPosition.Third){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+27);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+7);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+28);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+8);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+27);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+6);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+28);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+7);
						break;
					}
				}
			}else if(top == ChordPosition.Fifth){
				if(doubled == ChordPosition.Prime){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+19);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+20);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+18);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+19);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					}
				}
				if(doubled == ChordPosition.Third){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+19);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+20);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+18);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+19);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					}
				}
			}
		}else{
			if(top == ChordPosition.Prime){
				if(doubled == ChordPosition.Prime){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+12);
						notes[1] = new Note(notes[3].getId()+7);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+12);
						notes[1] = new Note(notes[3].getId()+8);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+12);
						notes[1] = new Note(notes[3].getId()+6);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+12);
						notes[1] = new Note(notes[3].getId()+7);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					}
				}
			}else if(top == ChordPosition.Third){
				if(doubled == ChordPosition.Prime){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+15);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+7);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+16);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+8);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+15);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+6);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+16);
						notes[1] = new Note(notes[3].getId()+12);
						notes[2] = new Note(notes[3].getId()+7);
						break;
					}
				}
				if(doubled == ChordPosition.Third){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+15);
						notes[1] = new Note(notes[3].getId()+7);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+16);
						notes[1] = new Note(notes[3].getId()+8);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+15);
						notes[1] = new Note(notes[3].getId()+6);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+16);
						notes[1] = new Note(notes[3].getId()+7);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					}
				}
			}else if(top == ChordPosition.Fifth){
				if(doubled == ChordPosition.Prime){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+19);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+20);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+18);
						notes[1] = new Note(notes[3].getId()+15);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+19);
						notes[1] = new Note(notes[3].getId()+16);
						notes[2] = new Note(notes[3].getId()+12);
						break;
					}
				}
				if(doubled == ChordPosition.Third){
					switch(alt){
					case Minor:
						notes[0] = new Note(notes[3].getId()+7);
						notes[1] = new Note(notes[3].getId()+3);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					case Augmented:
						notes[0] = new Note(notes[3].getId()+8);
						notes[1] = new Note(notes[3].getId()+4);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					case Diminished:
						notes[0] = new Note(notes[3].getId()+6);
						notes[1] = new Note(notes[3].getId()+3);
						notes[2] = new Note(notes[3].getId()+3);
						break;
					default:
						notes[0] = new Note(notes[3].getId()+7);
						notes[1] = new Note(notes[3].getId()+4);
						notes[2] = new Note(notes[3].getId()+4);
						break;
					}
				}
			}
		}
	}
	
	public Tonality getTonality() {
		return tonality;
	}
	
	public ScaleDegree getScDeg() {
		return scDeg;
	}
	
	protected void applyAlterations(Alteration alt){
		
	}
	
	protected void applySingleAlteration(Note n,ChordPosition notePos,Alteration alt){
		switch(alt){
		case Augmented:
			if(notePos == ChordPosition.Fifth){
				n.incrementId(1);
			}
			break;
		case Diminished:
			if(notePos == ChordPosition.Third){
				n.incrementId(-1);
			}
			if(notePos == ChordPosition.Fifth){
				n.incrementId(-1);
			}
			break;
		case Minor:
			if(notePos == ChordPosition.Third){
				n.incrementId(-1);
			}
			break;
		default:
			break;
		
		}
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
