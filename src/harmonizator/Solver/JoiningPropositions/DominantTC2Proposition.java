package harmonizator.Solver.JoiningPropositions;

import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordVariation;

public class DominantTC2Proposition extends JoiningProposition{
	public DominantTC2Proposition(JoiningProposition next) {
		super(next);
	}

	@Override
	protected ChordSuggestion makeSuggestion(Chord previous) {
		ChordSuggestion cs = new ChordSuggestion();
		cs.setScDeg(ScaleDegree.Dominant);
		cs.setChordVariation(ChordVariation.P2);
		return cs;
	}

}
