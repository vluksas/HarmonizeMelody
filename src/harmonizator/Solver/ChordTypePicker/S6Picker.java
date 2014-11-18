package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordVariation;

public class S6Picker extends ChordTypePickerGeneral{
	public S6Picker(){
		cs.setScDeg(ScaleDegree.Subdominant);
		cs.setChordVariation(ChordVariation.P6);
	}
	protected void performSelection(ChordSelector cs){
		cs.selectS6();
	}
}
