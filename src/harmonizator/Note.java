package harmonizator;

public class Note {
	private NoteValue val = NoteValue.Quarter; 
	private int id;
	private String octName;
	private String noteName;
	private String noteLetterName;//natos raidinis pavadinimas
	
	public double getNoteValue(){
		switch(val){
			case Eighth:
				return 0.125;
			case Half:
				return 0.5;
			case Quarter:
				return 0.25;
			case Sixteenth:
				return 0.0625;
			case Thirty_second:
				return 0.03125;
			case Whole:
				return 1.0;
			default:
				return 1.0;
			}
	}
	
	public void setVal(NoteValue val) {
		this.val = val;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		setNoteName();
		setOctName();
	}
	
	public String getOctName() {
		return octName;
	}
	
	public int getOctNameNumeric(){
		return (id-1)/12;
	}
	
	private void setOctName(){
		int octNameId = (id-1)/12;
		switch(octNameId){
		case 0: octName = "subkontroktava";
		break;
		case 1: octName = "kontroktava";
		break;
		case 2: octName = "didžioji";
		break;
		case 3: octName = "mažoji";
		break;
		case 4: octName = "pirmoji";
		break;
		case 5: octName = "antroji";
		break;
		case 6: octName = "trečioji";
		break;
		case 7: octName = "ketvirtoji";
		break;
		case 8: octName = "penktoji";
		break;
		default: octName = "";
		break;
		}
	}
	
	public String getNoteLetterName() {
		return noteLetterName;
	}
	
	public String getNoteName() {
		return noteName;
	}
	
	private void setNoteName(){
		int noteNameId = id%12;
		switch(noteNameId){
			case 1: noteName = "Do";
			noteLetterName = "C";
			break;
			case 2: noteName = "Do diez";
			noteLetterName = "Cis";
			break;
			case 3: noteName = "Re";
			noteLetterName = "D";
			break;
			case 4: noteName = "Mi bemol";
			noteLetterName = "Es";
			break;
			case 5: noteName = "Mi";
			noteLetterName = "E";
			break;
			case 6: noteName = "Fa";
			noteLetterName = "F";
			break;
			case 7: noteName = "Fa diez";
			noteLetterName = "Fis";
			break;
			case 8: noteName = "Sol";
			noteLetterName = "G";
			break;
			case 9: noteName = "Sol diez";
			noteLetterName = "Gis";
			break;
			case 10: noteName = "La";
			noteLetterName = "A";
			break;
			case 11: noteName = "Si bemol";
			noteLetterName = "B";
			break;
			default:
			noteName = "Si";
			noteLetterName = "H";
			break;
		}
	}
	
	public Note(){
		id = -1;
	}
	
	public Note(int nId){
		setId(nId);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((noteLetterName == null) ? 0 : noteLetterName.hashCode());
		result = prime * result
				+ ((noteName == null) ? 0 : noteName.hashCode());
		result = prime * result + ((octName == null) ? 0 : octName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (id != other.id)
			return false;
		if (noteLetterName == null) {
			if (other.noteLetterName != null)
				return false;
		} else if (!noteLetterName.equals(other.noteLetterName))
			return false;
		if (noteName == null) {
			if (other.noteName != null)
				return false;
		} else if (!noteName.equals(other.noteName))
			return false;
		if (octName == null) {
			if (other.octName != null)
				return false;
		} else if (!octName.equals(other.octName))
			return false;
		return true;
	}
	
	public void incrementId(int num){
		setId(id + num);
	}
	
	//Some methods for working with notes:
	public static int distance(Note a,Note b){
		return Math.abs(a.getId()-b.getId());
	}
	
	public static ScaleDegree getScaleDegree(Note note, Note tonic){
		while(tonic.getId() > note.getId()%12){
			tonic.setId(tonic.getId()-12);
		}
		int difference = Math.abs(note.getId()%12 - tonic.getId()%12);
		switch(difference){
			case 0: return ScaleDegree.Tonic;
			case 1: return ScaleDegree.Supertonic;
			case 2: return ScaleDegree.Supertonic;
			case 3: return ScaleDegree.Mediant;
			case 4: return ScaleDegree.Mediant;
			case 5: return ScaleDegree.Subdominant;
			case 6: return ScaleDegree.Subdominant;
			case 7: return ScaleDegree.Dominant;
			case 8: return ScaleDegree.Submediant;
			case 9: return ScaleDegree.Submediant;
			case 10: return ScaleDegree.Subtonic;
			case 11: return ScaleDegree.Subtonic;
			default:return ScaleDegree.Tonic;
		}
	}
	
	public String toString(){
		return noteLetterName + getOctNameNumeric();
	}

}
