package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordVariation;

public class T5Picker extends ChordTypePickerGeneral{
	public T5Picker(){
		cs.setScDeg(ScaleDegree.Tonic);
		cs.setChordVariation(ChordVariation.P5);
	}
	protected void performSelection(ChordSelector cs){
		cs.selectT5();
	}
}
