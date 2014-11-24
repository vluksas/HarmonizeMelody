package harmonizator.Solver.JoiningPropositions;

import harmonizator.Chords.Chord;
import harmonizator.Solver.ChordSuggestion;

public class KeepSameProposition extends JoiningProposition{
	public KeepSameProposition(JoiningProposition next) {
		super(next);
	}

	@Override
	protected ChordSuggestion makeSuggestion(Chord previous) {
		//Keep the same scale degree (e.g. previous = T5, suggestion = T5)
		ChordSuggestion cs = new ChordSuggestion();
		cs.setScDeg(previous.getScDeg());
		keepInversion(cs,previous);
		return cs;
	}

}
