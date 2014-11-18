package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.*;



public class ExpositionalHarmonyEndOfBarState extends ChordSuggestorState{
	private static final int NUMBER_OF_OPTIONS = 8;
	private static ExpositionalHarmonyEndOfBarState instance = null;
	
	private ExpositionalHarmonyEndOfBarState(){
	}
	
	public static ExpositionalHarmonyEndOfBarState getInstance(){
		if(instance == null){
			instance = new ExpositionalHarmonyEndOfBarState();
			return instance;
		}else{
			return instance; 
		}
	}
	@Override
	public ChordSuggestion suggest(int optionNum, Chord previous, Note mel) {
		// TODO Auto-generated method stub
		ChordSuggestion cs = new ChordSuggestion();
		switch(optionNum){
			case 1:
				differentSDByPreference(cs,previous,1);
				break;
			case 2:
				differentSDByPreferenceSwitchInversion(cs,previous,1);
				break;
			case 3:
				differentSDByPreference(cs,previous,2);
				break;
			case 4:
				differentSDByPreferenceSwitchInversion(cs,previous,2);
				break;
			case 5:
				differentSDByPreference(cs,previous,3);
				break;
			case 6:
				differentSDByPreferenceSwitchInversion(cs,previous,3);
				break;
			case 7:
				keepSame(cs,previous);
				break;
			case 8:
				keepSDswitchInversion(cs,previous);
				break;
			default:
				cs.unset();
				break;	
		}
		return cs;
	}
	@Override
	public int getNumOfOpts() {
		// TODO Auto-generated method stub
		return NUMBER_OF_OPTIONS;
	}
}
