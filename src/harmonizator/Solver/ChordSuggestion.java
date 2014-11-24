package harmonizator.Solver;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordType;

public class ChordSuggestion {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chordVariation == null) ? 0 : chordVariation.hashCode());
		result = prime * result + ((ct == null) ? 0 : ct.hashCode());
		result = prime * result + (isSet ? 1231 : 1237);
		result = prime * result + ((scDeg == null) ? 0 : scDeg.hashCode());
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
		ChordSuggestion other = (ChordSuggestion) obj;
		if (chordVariation != other.chordVariation)
			return false;
		if (ct != other.ct)
			return false;
		if (isSet != other.isSet)
			return false;
		if (scDeg != other.scDeg)
			return false;
		return true;
	}

	private boolean isSet = true;
	private ScaleDegree scDeg;
	private ChordVariation chordVariation;
	private ChordType ct;

	public ScaleDegree getScDeg() {
		return scDeg;
	}

	public void setScDeg(ScaleDegree scDeg) {
		this.scDeg = scDeg;
		if(scDeg == null){
			this.unset();
		}
	}

	public boolean isSet() {
		return isSet;
	}

	public void markSet() {
		this.isSet = true;
	}
	public void unset() {
		this.isSet = false;
	}

	public ChordVariation getChordVariation() {
		return chordVariation;
	}

	public void setChordVariation(ChordVariation cv) {
		this.chordVariation = cv;
		if(chordVariation == ChordVariation.P5 ||
				chordVariation == ChordVariation.P6 ||	
				chordVariation == ChordVariation.P64){
			ct = ChordType.Trichord;
		}else{
			ct = ChordType.Tetrachord;
		}
	}

	public ChordType getChordType() {
		return ct;
	}
	public String toString(){
		if(isSet){
		return "CV:" + chordVariation + "|SD:" + scDeg;
		}
		return "Not set";
	}
}
