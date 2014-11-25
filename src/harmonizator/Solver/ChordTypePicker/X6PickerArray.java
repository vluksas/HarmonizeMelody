package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public class X6PickerArray implements ChordTypePickerArray{

	private ChordSuggestion cs;
	public X6PickerArray(ScaleDegree scDeg){
		this.setScDeg(scDeg);
	}
	public void setScDeg(ScaleDegree scDeg){
		cs.setScDeg(scDeg);
	}
	@Override
	public void suggest(ChordSelector cs) {
		// TODO Auto-generated method stub
		cs.selectScaleDegree(this.cs.getScDeg());
		cs.selectX6();
		
	}
	@Override
	public ChordSuggestion getSuggestion() {
		return cs;
	}
	
}
