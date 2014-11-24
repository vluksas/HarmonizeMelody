package harmonizator.Solver.JoiningPropositions;

import harmonizator.Chords.Chord;
import harmonizator.Solver.ChordSuggestion;

public class SwitchSDKeepInversionProposition extends JoiningProposition{
	private int preferenceLevel;
	public SwitchSDKeepInversionProposition(JoiningProposition next,int preference) {
		super(next);
		if(preference >= MIN_PREFERENCE &&  preference <= MAX_PREFERENCE){
			preferenceLevel = preference;
		}else{
			preferenceLevel = 1;
		}
	}

	@Override
	protected ChordSuggestion makeSuggestion(Chord previous) {
		//Different scale degree first preference (e.g. previous = T5, suggestion = S5)
		ChordSuggestion cs = new ChordSuggestion();
		cs.setScDeg(getRelatedScaleDegree(previous.getScDeg(),preferenceLevel));
		keepInversion(cs,previous);
		if(cs.isSet()){
			return cs;
		}else{
			return null;
		}
	}

}
