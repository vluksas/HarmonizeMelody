package harmonizator.Solver.JoiningPropositions;

import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Chords.Tetrachord;
import harmonizator.Chords.Tetrachord2;
import harmonizator.Chords.Tetrachord34;
import harmonizator.Chords.Tetrachord56;
import harmonizator.Chords.Trichord;
import harmonizator.Chords.Trichord6;
import harmonizator.Chords.Trichord64;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordVariation;

public abstract class JoiningProposition {
	public static final int MIN_PREFERENCE = 1;//Most preferred scaleDegree in joining (minimum case at getRelatedScaleDegree;used by some inheriting classes)
	public static final int MAX_PREFERENCE = 4;//Least preferred scaleDegree in joining (maximum case at getRelatedScaleDegree;used by some inheriting classes)
	protected JoiningProposition next;
	
	public final ChordSuggestion suggest(int orderOfRequest, Chord previous){//orderOfRequest – Number which denotes how many acceptable results should be skipped
		ChordSuggestion offer = makeSuggestion(previous);
		if(next == null && (offer == null || orderOfRequest != 0)){
			ChordSuggestion cs = new ChordSuggestion();
			cs.unset();
			return cs;
		}
		if(offer != null){
			if(orderOfRequest == 0){
				return offer;
			}else{
				orderOfRequest--;
				return next.suggest(orderOfRequest, previous);
			}
		}else{
			return next.suggest(orderOfRequest, previous);			
		}
	}
	public JoiningProposition(JoiningProposition next){
		this.next = next;
	}
	public void setNext(JoiningProposition next){
		this.next = next;
	}
	protected abstract ChordSuggestion makeSuggestion(Chord previous);
	
	protected static ScaleDegree getRelatedScaleDegree(ScaleDegree scDeg, int level){
		switch(level){
			case 1: 
				switch(scDeg){
				case Dominant:
					return ScaleDegree.Tonic;
				case Mediant:
					return ScaleDegree.Tonic;
				case Subdominant:
					return ScaleDegree.Dominant;
				case Submediant:
					return ScaleDegree.Subdominant;
				case Subtonic:
					return ScaleDegree.Dominant;
				case Supertonic:
					return ScaleDegree.Dominant;
				case Tonic:
					return ScaleDegree.Subdominant;
				default:
					return scDeg;	
				}
			case 2: 
				switch(scDeg){
				case Dominant:
					return ScaleDegree.Submediant;
				case Mediant:
					return ScaleDegree.Dominant;
				case Subdominant:
					return ScaleDegree.Supertonic;
				case Submediant:
					return ScaleDegree.Supertonic;
				case Subtonic:
					return ScaleDegree.Tonic;
				case Supertonic:
					return ScaleDegree.Tonic;
				case Tonic:
					return ScaleDegree.Dominant;
				default:
					return scDeg;	
				}
			case 3: 
				switch(scDeg){
				case Dominant:
					return ScaleDegree.Subtonic;
				case Mediant:
					return ScaleDegree.Submediant;
				case Subdominant:
					return ScaleDegree.Tonic;
				case Submediant:
					return ScaleDegree.Tonic;
				case Subtonic:
					return null;
				case Supertonic:
					return null;
				case Tonic:
					return ScaleDegree.Supertonic;
				default:
					return scDeg;	
				}
			case 4: 
				switch(scDeg){
				case Dominant:
					return null;
				case Mediant:
					return ScaleDegree.Subtonic;
				case Subdominant:
					return ScaleDegree.Submediant;
				case Submediant:
					return ScaleDegree.Mediant;
				case Subtonic:
					return null;
				case Supertonic:
					return null;
				case Tonic:
					return ScaleDegree.Submediant;
				default:
					return scDeg;	
				}	
			default: return scDeg;
		}
	}
	protected static void keepInversion(ChordSuggestion cs,Chord previous){
		if(previous.getClass() == Trichord.class){
			cs.setChordVariation(ChordVariation.P5);
		}else if(previous.getClass() == Trichord6.class){
			cs.setChordVariation(ChordVariation.P6);
		}else if(previous.getClass() == Trichord64.class){
			cs.setChordVariation(ChordVariation.P64);
		}else if(previous.getClass() == Tetrachord.class){
			cs.setChordVariation(ChordVariation.P7);
		}else if(previous.getClass() == Tetrachord56.class){
			cs.setChordVariation(ChordVariation.P56);
		}else if(previous.getClass() == Tetrachord34.class){
			cs.setChordVariation(ChordVariation.P34);
		}else if(previous.getClass() == Tetrachord2.class){
			cs.setChordVariation(ChordVariation.P2);
		}
	}
	protected static void nextInversion(ChordSuggestion cs,Chord previous){
		if(previous.getClass() == Trichord.class){
			cs.setChordVariation(ChordVariation.P6);
		}else if(previous.getClass() == Trichord6.class){
			cs.setChordVariation(ChordVariation.P5);
		}else if(previous.getClass() == Trichord64.class){
			cs.unset();
		}else if(previous.getClass() == Tetrachord.class){
			cs.setChordVariation(ChordVariation.P56);
		}else if(previous.getClass() == Tetrachord56.class){
			cs.setChordVariation(ChordVariation.P34);
		}else if(previous.getClass() == Tetrachord34.class){
			cs.setChordVariation(ChordVariation.P2);
		}else if(previous.getClass() == Tetrachord2.class){
			cs.unset();
		}
	}
}
