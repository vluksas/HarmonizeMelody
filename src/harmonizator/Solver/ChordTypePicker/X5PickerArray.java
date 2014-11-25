package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public class X5PickerArray implements ChordTypePickerArray{

	private ChordSuggestion cs;
	public X5PickerArray(ScaleDegree scDeg){
		this.setScDeg(scDeg);
	}
	public void setScDeg(ScaleDegree scDeg){
		cs.setScDeg(scDeg);
	}
	@Override
	public void suggest(ChordSelector cs) {
		// TODO Auto-generated method stub
		cs.selectScaleDegree(this.cs.getScDeg());
		cs.selectX5();
		
	}
	@Override
	public ChordSuggestion getSuggestion() {
		return cs;
	}
	
}
