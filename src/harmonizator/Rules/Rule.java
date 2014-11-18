package harmonizator.Rules;

import harmonizator.Chords.Chord;

public interface Rule {
	public boolean correctJoining(Chord a,Chord b);
	public boolean correctJoining(Chord [] cSet);
	public boolean isCompulsory();
	public int getImportanceLevel();
}