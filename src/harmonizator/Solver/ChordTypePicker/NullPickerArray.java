package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public class NullPickerArray implements ChordTypePickerArray{
	
	public NullPickerArray(){

	}
	public NullPickerArray(ScaleDegree scDeg){

	}

	@Override
	public void suggest(ChordSelector cs) {

	}
	@Override
	public ChordSuggestion getSuggestion() {
		ChordSuggestion cs = new ChordSuggestion();
		cs.unset();
		return cs;
	}
	
}
