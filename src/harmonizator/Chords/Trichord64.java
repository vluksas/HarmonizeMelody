package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class Trichord64 extends Trichord{
	
	private boolean cadential;
	
	public Trichord64(Tonality t, ScaleDegree scDeg, Alteration alt, Note base,
			ChordPosition top, boolean isWide) {
		this.tonality = t;
		this.scDeg = scDeg;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		makeTrichord(alt,top,isWide);
		this.cadential = false;
	}
	
	public Trichord64(Tonality t, ScaleDegree scDeg, Alteration alt, Note base,
			ChordPosition top, boolean isWide, boolean isCadential) {
		this.tonality = t;
		this.scDeg = scDeg;
		this.numOfNotes = 4;
		notes = new Note[numOfNotes];
		notes[3] = base;
		makeTrichord(alt,top,isWide);
		this.cadential = isCadential;
	}
	
	private void makeTrichord(Alteration alt,ChordPosition top,boolean isWide){
		if(top == ChordPosition.Seventh){
			top = ChordPosition.Prime;
		}
		switch(top){
		case Fifth:
			if(isWide){
				notes[0] = new Note(notes[3].getId()+24);
				notes[1] = new Note(notes[3].getId()+17);
				notes[2] = new Note(notes[3].getId()+9);
			}else{
				notes[0] = new Note(notes[3].getId()+12);
				notes[1] = new Note(notes[3].getId()+9);
				notes[2] = new Note(notes[3].getId()+5);
			}
			break;
		case Prime:
			if(isWide){
				notes[0] = new Note(notes[3].getId()+29);
				notes[1] = new Note(notes[3].getId()+21);
				notes[2] = new Note(notes[3].getId()+12);
			}else{
				notes[0] = new Note(notes[3].getId()+17);
				notes[1] = new Note(notes[3].getId()+12);
				notes[2] = new Note(notes[3].getId()+9);
			}
			break;
		case Third:
			if(isWide){
				notes[0] = new Note(notes[3].getId()+21);
				notes[1] = new Note(notes[3].getId()+12);
				notes[2] = new Note(notes[3].getId()+5);
			}else{
				notes[0] = new Note(notes[3].getId()+9);
				notes[1] = new Note(notes[3].getId()+5);
				notes[2] = new Note(notes[3].getId()+0);
			}
			break;
		default:
			break;
			
		}
		applyAlterations(alt);
	}
	
	@Override
	protected void applyAlterations(Alteration alt){
		for(Note n: notes){
			if((n.getId() - notes[3].getId())%12 == 9){
				applySingleAlteration(n,ChordPosition.Third,alt);
			}else if((n.getId() - notes[3].getId())%12 == 0){
				applySingleAlteration(n,ChordPosition.Fifth,alt);
			}
		}
	}
	
	public boolean isCadential() {
		return cadential;
	}
}
