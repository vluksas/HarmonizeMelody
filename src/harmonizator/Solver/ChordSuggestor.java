package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.Chords.Chord;

public class ChordSuggestor {
	private ChordSuggestorState state = null;
	private int meterTopN;
	private int meterBottomN;
	private double notesPerBar;
	
	private double positionInBar = 0.0;//Defines which position in the given bar the solver currently is
	private int barNumber = 1;//Defines the number of bar the solver currently is in
	public void setMeter(int meterTopN, int meterBottomN){
		if(meterTopN < 1 || meterBottomN < 1){
			this.meterTopN = 2;
			this.meterBottomN = 4;
		}else{
			this.meterTopN = meterTopN;
			this.meterBottomN = meterBottomN;
		}
		this.notesPerBar = (double)this.meterTopN/(double)this.meterBottomN;
	}
	public void setPositionInSolution(int barNumber,double positionInBar){
		if(barNumber <= 0){
			this.barNumber = 1;
		}else{
			this.barNumber = barNumber;
		}
		if(positionInBar <= 0 || positionInBar >= notesPerBar){
			this.positionInBar = 0.0;
		}else{
			this.positionInBar = positionInBar;
		}
	}
	public ChordSuggestor(){
		state = InitialSuggestorState.getInstance();
		this.meterTopN = 2;
		this.meterBottomN = 4;
		this.notesPerBar = (double)this.meterTopN/(double)this.meterBottomN;
	}
	public ChordSuggestor(int meterTopN, int meterBottomN){
		state = InitialSuggestorState.getInstance();
		setMeter(meterTopN,meterBottomN);

	}
	private void setState(ChordSuggestorState nextState){
		state = nextState;
	}
	public ChordSuggestorState getState(){
		return state;
	}
	public int getNumOfOpts(){
		if(state == null){
			return 0;
		}
		return state.getNumOfOpts();
	}
	public ChordSuggestion suggest(int optionNum, Chord previous, Note mel){
		selectState();
		if(state == null){
			return null;
		}
		return state.suggest(optionNum,previous,mel);
	}
	public void updatePositionInBar(double noteLength){
		if(notesPerBar <= 0){
			return;
		}
		positionInBar += noteLength;
		while(positionInBar >= notesPerBar){
			positionInBar -= notesPerBar;
			barNumber++;
		}
	}
	public void resetBarPosition(){
		positionInBar = 0.0;
		barNumber = 1;
		setState(InitialSuggestorState.getInstance());
	}
	public double getNotesPerBar() {
		return notesPerBar;
	}
	private void selectState(){
		if(Double.compare(positionInBar, 0.0) == 0 && barNumber == 1){
			setState(InitialSuggestorState.getInstance());
			return;
		}
		if(Double.compare(positionInBar, 0.0) == 0 && barNumber > 1){
			setState(ExpositionalHarmonyEndOfBarState.getInstance());
			return;
		}else{
			setState(ExpositionalHarmonyGeneralState.getInstance());
			return;
		}
	}
}
