package harmonizator.Solver;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordType;

public class ChordSuggestion {
	private boolean isSet = true;
	private ScaleDegree scDeg;
	private ChordVariation chordVariation;
	private ChordType ct;

	public ScaleDegree getScDeg() {
		return scDeg;
	}

	public void setScDeg(ScaleDegree scDeg) {
		this.scDeg = scDeg;
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
}
