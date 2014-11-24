package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Solver.JoiningPropositions.JoiningProposition;

public abstract class ChordSuggestorState {
	protected JoiningProposition proposer = null;
	public ChordSuggestion suggest(int optionNum, Chord previous, Note mel) {
		ChordSuggestion cs = proposer.suggest(optionNum, previous);
		return cs;	
	}
	public abstract int getNumOfOpts();
}