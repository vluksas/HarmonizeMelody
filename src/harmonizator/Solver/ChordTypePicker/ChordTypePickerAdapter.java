package harmonizator.Solver.ChordTypePicker;

import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public class ChordTypePickerAdapter implements ChordTypePicker{

	ChordSuggestorArray cpicker;
	ChordTypePicker stubPicker; 
	public ChordTypePickerAdapter(){
		cpicker = new ChordSuggestorArray();
	}
	@Override
	public void pickType(ChordSelector cs, ChordSuggestion csug) {
		cpicker.pickType(cs, csug);
		stubPicker = new ChordTypePickerNull();
	}

	@Override
	public void add(ChordTypePicker cp) {
		ChordSuggestion cs = cp.getChordSuggestion();
		ChordTypePickerArray realAddition;
		switch(cs.getChordVariation()){
		case P5:
			realAddition = new X5PickerArray(cs.getScDeg());
		case P6:
			realAddition = new X6PickerArray(cs.getScDeg());
		default:
			realAddition = new NullPickerArray();//unimplemented case
			break;
		}
		cpicker.add(realAddition);
		
	}

	//Methods irrelevant for clients, thus no need to properly implement them.
	@Override
	public ChordTypePicker getChild(int numOfChild) {
		return stubPicker;
	}

	@Override
	public ChordSuggestion getChordSuggestion() {
		return stubPicker.getChordSuggestion();
	}

}
