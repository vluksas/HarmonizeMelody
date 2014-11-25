package harmonizator.Solver;

import harmonizator.Solver.JoiningPropositions.DominantProposition;
import harmonizator.Solver.JoiningPropositions.DominantTC2Proposition;
import harmonizator.Solver.JoiningPropositions.JoiningProposition;
import harmonizator.Solver.JoiningPropositions.TonicProposition;



public class InitialSuggestorState extends ChordSuggestorState{
	private static final int NUMBER_OF_OPTIONS = 3;
	private static InitialSuggestorState instance = null;
	private InitialSuggestorState(){
		buildChain();
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
	public int getNumOfOpts() {
		// TODO Auto-generated method stub
		return NUMBER_OF_OPTIONS;
	}
	private void buildChain(){
		JoiningProposition link3 = new DominantTC2Proposition(null);
		JoiningProposition link2 = new DominantProposition(null);
		proposer = new TonicProposition(null);
		proposer.setNext(link2);
		link2.setNext(link3);
		
	}
}
