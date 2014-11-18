package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordVariation;

public class X5Picker extends ChordTypePickerGeneral{
	public X5Picker(ScaleDegree scDeg){
		cs.setScDeg(scDeg);
		cs.setChordVariation(ChordVariation.P5);
	}
	protected void performSelection(ChordSelector csel){
		csel.selectScaleDegree(this.cs.getScDeg());
		csel.selectX5();
	}
}
