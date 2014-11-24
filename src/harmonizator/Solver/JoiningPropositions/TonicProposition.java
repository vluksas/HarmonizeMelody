package harmonizator.Solver.JoiningPropositions;

import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordVariation;

public class TonicProposition extends JoiningProposition{
	public TonicProposition(JoiningProposition next) {
		super(next);
	}

	@Override
	protected ChordSuggestion makeSuggestion(Chord previous) {
		ChordSuggestion cs = new ChordSuggestion();
		cs.setScDeg(ScaleDegree.Tonic);
		cs.setChordVariation(ChordVariation.P5);
		return cs;
	}

}
