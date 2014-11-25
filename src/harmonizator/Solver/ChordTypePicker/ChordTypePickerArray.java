package harmonizator.Solver.ChordTypePicker;

import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public interface ChordTypePickerArray {
	public void suggest(ChordSelector cs);
	public ChordSuggestion getSuggestion();
}
