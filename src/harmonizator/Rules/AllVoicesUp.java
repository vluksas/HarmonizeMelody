package harmonizator.Rules;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Solver.ExpositionalHarmonyGeneralState;

public class AllVoicesUp extends GenericRule{

	private static AllVoicesUp instance = null;
	protected AllVoicesUp(){
	}
	
	public static AllVoicesUp getInstance(){
		if(instance == null){
			instance = new AllVoicesUp();
			return instance;
		}else{
			return instance; 
		}
	}
	@Override
	public boolean correctJoining(Chord a, Chord b) {
		if(a == null || b == null){
			return true;
		}
		for(int i = 0;i < a.getNumOfNotes();i++){
			if(a.getNote(i).getId() >= b.getNote(i).getId()){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean correctJoining(Chord[] cSet) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
