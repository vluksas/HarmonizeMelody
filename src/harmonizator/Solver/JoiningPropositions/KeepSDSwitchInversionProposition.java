package harmonizator.Solver.JoiningPropositions;

import harmonizator.Chords.Chord;
import harmonizator.Solver.ChordSuggestion;

public class KeepSDSwitchInversionProposition extends JoiningProposition{
	public KeepSDSwitchInversionProposition(JoiningProposition next) {
		super(next);
	}

	@Override
	protected ChordSuggestion makeSuggestion(Chord previous) {
		//Keep the same scale degree but switch inversion (e.g. previous = T5, suggestion = T6)
		ChordSuggestion cs = new ChordSuggestion();
		cs.setScDeg(previous.getScDeg());
		nextInversion(cs,previous);
		if(cs.isSet()){
			return cs;
		}else{
			return null;
		}
	}

}
