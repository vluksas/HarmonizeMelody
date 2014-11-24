package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.Chords.*;
import harmonizator.Solver.JoiningPropositions.JoiningProposition;
import harmonizator.Solver.JoiningPropositions.KeepSDSwitchInversionProposition;
import harmonizator.Solver.JoiningPropositions.KeepSameProposition;
import harmonizator.Solver.JoiningPropositions.SwitchSDKeepInversionProposition;
import harmonizator.Solver.JoiningPropositions.SwitchSDSwitchInversionProposition;



public class ExpositionalHarmonyGeneralState extends ChordSuggestorState{
	private static final int NUMBER_OF_OPTIONS = 10;
	private static ExpositionalHarmonyGeneralState instance = null;
	private JoiningProposition proposer = null;
	private ExpositionalHarmonyGeneralState(){
		buildChain();
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
		ChordSuggestion cs = proposer.suggest(optionNum, previous);
		return cs;	
	}
	@Override
	public int getNumOfOpts() {
		// TODO Auto-generated method stub
		return NUMBER_OF_OPTIONS;
	}
	private void buildChain(){
		JoiningProposition links[] = new JoiningProposition[JoiningProposition.MAX_PREFERENCE*2+1];
		links[JoiningProposition.MAX_PREFERENCE*2] = null;
		for(int i = JoiningProposition.MAX_PREFERENCE;i >= JoiningProposition.MIN_PREFERENCE;i--){
			links[i*2-1] = new SwitchSDSwitchInversionProposition(links[i*2],i);
			links[i*2-2] = new SwitchSDKeepInversionProposition(links[i*2-1],i);
		}
		JoiningProposition link2 = new KeepSDSwitchInversionProposition(links[0]);
		proposer = new KeepSameProposition(link2);
	}
}
