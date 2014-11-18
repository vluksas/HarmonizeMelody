package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.*;



public class ExpositionalHarmonyGeneralState extends ChordSuggestorState{
	private static final int NUMBER_OF_OPTIONS = 8;
	private static ExpositionalHarmonyGeneralState instance = null;
	
	private ExpositionalHarmonyGeneralState(){
	}
	
	public static ExpositionalHarmonyGeneralState getInstance(){
		if(instance == null){
			instance = new ExpositionalHarmonyGeneralState();
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
				keepSame(cs,previous);
				break;
			case 2:
				keepSDswitchInversion(cs,previous);
				break;
			case 3:
				differentSDByPreference(cs,previous,1);
				break;
			case 4:
				differentSDByPreferenceSwitchInversion(cs,previous,1);
				break;
			case 5:
				differentSDByPreference(cs,previous,2);
				break;
			case 6:
				differentSDByPreferenceSwitchInversion(cs,previous,2);
				break;
			case 7:
				differentSDByPreference(cs,previous,3);
				break;
			case 8:
				differentSDByPreferenceSwitchInversion(cs,previous,3);
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
