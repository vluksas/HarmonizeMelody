package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordVariation;

public class S5Picker extends ChordTypePickerGeneral{
	public S5Picker(){
		cs.setScDeg(ScaleDegree.Subdominant);
		cs.setChordVariation(ChordVariation.P5);
	}
	protected void performSelection(ChordSelector cs){
		cs.selectS5();
	}
}
