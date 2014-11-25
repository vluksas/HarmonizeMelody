package harmonizator.Solver.ChordTypePicker;

import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public class ChordTypePickerNull implements ChordTypePicker{


	public ChordTypePickerNull(){

	}
	@Override
	public void pickType(ChordSelector cs, ChordSuggestion csug) {

	}
	@Override
	public void add(ChordTypePicker cp) {
		
	}
	@Override
	public ChordTypePicker getChild(int numOfChild) {
		return new ChordTypePickerNull();
	}
	@Override
	public ChordSuggestion getChordSuggestion() {
		ChordSuggestion cs = new ChordSuggestion();
		cs.unset();
		return cs;
	}
}