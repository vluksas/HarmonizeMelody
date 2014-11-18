package harmonizator.Rules;

import harmonizator.Note;
import harmonizator.Chords.Chord;
import harmonizator.Solver.ExpositionalHarmonyGeneralState;

public class ParallelFifths extends GenericRule{

	private static ParallelFifths instance = null;
	protected ParallelFifths(){
	}
	
	public static ParallelFifths getInstance(){
		if(instance == null){
			instance = new ParallelFifths();
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
		if(a.getNumOfNotes() == b.getNumOfNotes()){
			for(int i = 0;i < a.getNumOfNotes()-1;i++){
				for(int j = (i+1);j < a.getNumOfNotes();j++){
					if((Note.distance(a.getNote(i), a.getNote(j)))%12 ==  7 &&  
							(Note.distance(b.getNote(i), b.getNote(j)))%12 ==  7 &&
							(!(a.getNote(i).equals(b.getNote(i))))){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean correctJoining(Chord[] cSet) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
