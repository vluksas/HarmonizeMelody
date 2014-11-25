package harmonizator.Solver.ChordTypePicker;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public class ChordTypePickerArrayAdapter implements ChordTypePicker{

	private ChordTypePickerGeneralArray cpicker;
	private ChordTypePicker stubPicker; 
	
	public ChordTypePickerArrayAdapter(){
		cpicker = new ChordTypePickerGeneralArray();
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
			break;
		case P6:
			realAddition = new X6PickerArray(cs.getScDeg());
			break;
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
	public static ChordTypePickerArrayAdapter buildBaseList(){
		//equivalent of ChordTypePickerGeneral.buildBaseChordTree()
		ChordTypePickerArrayAdapter ctpa = new ChordTypePickerArrayAdapter();
		addBasePickers(ctpa);
		return ctpa;
	}
	private static void addBasePickers(ChordTypePickerArrayAdapter ctpa) {
		ctpa.cpicker.add(new X5PickerArray(ScaleDegree.Tonic));
		ctpa.cpicker.add(new X5PickerArray(ScaleDegree.Subdominant));
		ctpa.cpicker.add(new X5PickerArray(ScaleDegree.Dominant));
	}

}
