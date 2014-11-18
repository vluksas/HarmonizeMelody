package harmonizator.Rules;

import harmonizator.Chords.Chord;


public abstract class GenericRule implements Rule {
	@Override
	public boolean correctJoining(Chord a, Chord b) {
		return true;
	}
	@Override
	public boolean correctJoining(Chord[] cSet) {
		return true;
	}
	private int importanceLevel = -1;
	private boolean compulsory = true;
	@Override
	public boolean isCompulsory() {
		return compulsory;
	}
	@Override
	public int getImportanceLevel() {
		if(!compulsory){
			return importanceLevel;
		}else{
			return -1;
		}
	}
	public void setImportanceLevel(int importanceLevel) {
		this.importanceLevel = importanceLevel;
	}
	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
		importanceLevel = -1;
	}
}
