package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordVariation;

public class D5Picker extends ChordTypePickerGeneral{
	public D5Picker(){
		cs.setScDeg(ScaleDegree.Dominant);
		cs.setChordVariation(ChordVariation.P5);
	}
	protected void performSelection(ChordSelector cs){
		cs.selectD5();
	}
}
