package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Chords.*;



public class InitialSuggestorState extends ChordSuggestorState{
	private static final int NUMBER_OF_OPTIONS = 3;
	private static InitialSuggestorState instance = null;
	
	private InitialSuggestorState(){
	}
	
	public static InitialSuggestorState getInstance(){
		if(instance == null){
			instance = new InitialSuggestorState();
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
				suggestTonic(cs);
				break;
			case 2:
				suggestDominant(cs);
				break;
			case 3:
				suggestDominantTC2(cs);
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
