package harmonizator.Solver.ChordTypePicker;

import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

import java.util.ArrayList;

public class ChordTypePickerGeneralArray {
	private ArrayList<ChordTypePickerArray> chordTypes;
	
	public ChordTypePickerGeneralArray(){
		chordTypes = new ArrayList<ChordTypePickerArray>();
	}
	
	public void add(ChordTypePickerArray element){
		chordTypes.add(element);
	}
	
	public void pickType(ChordSelector cs, ChordSuggestion csug){
		for(ChordTypePickerArray cp: chordTypes){
			if(cp.getSuggestion().equals(csug)){
				cp.suggest(cs);
			}
		}
	}
	
}
