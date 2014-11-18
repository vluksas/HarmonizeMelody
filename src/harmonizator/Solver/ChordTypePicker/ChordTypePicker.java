package harmonizator.Solver.ChordTypePicker;

import harmonizator.Chords.ChordSelector;
import harmonizator.Solver.ChordSuggestion;

public interface ChordTypePicker {
	public void pickType(ChordSelector cs, ChordSuggestion csug);
	public void add(ChordTypePicker cp);
	public ChordTypePicker getChild(int numOfChild);
	public ChordSuggestion getChordSuggestion();
}
