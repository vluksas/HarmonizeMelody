package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Chords.Tetrachord;
import harmonizator.Chords.Tetrachord2;
import harmonizator.Chords.Tetrachord34;
import harmonizator.Chords.Tetrachord56;
import harmonizator.Chords.Trichord;
import harmonizator.Chords.Trichord6;
import harmonizator.Chords.Trichord64;

public abstract class ChordSuggestorState {
	public abstract ChordSuggestion suggest(int optionNum, Chord previous, Note mel);
	public abstract int getNumOfOpts();
	
	//----Suggestions:
	private static void keepInversion(ChordSuggestion cs,Chord previous){
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
	private static void nextInversion(ChordSuggestion cs,Chord previous){
		if(previous.getClass() == Trichord.class){
			cs.setChordVariation(ChordVariation.P6);
		}else if(previous.getClass() == Trichord6.class){
			cs.setChordVariation(ChordVariation.P5);
		}else if(previous.getClass() == Trichord64.class){
			cs.setChordVariation(ChordVariation.P64);
		}else if(previous.getClass() == Tetrachord.class){
			cs.setChordVariation(ChordVariation.P56);
		}else if(previous.getClass() == Tetrachord56.class){
			cs.setChordVariation(ChordVariation.P34);
		}else if(previous.getClass() == Tetrachord34.class){
			cs.setChordVariation(ChordVariation.P2);
		}else if(previous.getClass() == Tetrachord2.class){
			cs.setChordVariation(ChordVariation.P2);
		}
	}
	protected static void keepSame(ChordSuggestion cs,Chord previous){
		//Keep the same scale degree (e.g. previous = T5, suggestion = T5)
		cs.setScDeg(previous.getScDeg());
		keepInversion(cs,previous);
	}
	
	protected static void keepSDswitchInversion(ChordSuggestion cs,Chord previous){
		//Keep the same scale degree but switch inversion (e.g. previous = T5, suggestion = T6)
		cs.setScDeg(previous.getScDeg());
		nextInversion(cs,previous);
	}
	
	protected static void differentSDByPreferenceSwitchInversion(ChordSuggestion cs,Chord previous,int preferenceLevel){
		//Different scale degree first preference (e.g. previous = T5, suggestion = S5)
		cs.setScDeg(getRelatedScaleDegree(previous.getScDeg(),preferenceLevel));
		nextInversion(cs,previous);
	}
	
	protected static void differentSDByPreference(ChordSuggestion cs,Chord previous,int preferenceLevel){
		//Different scale degree first preference (e.g. previous = T5, suggestion = S5)
		cs.setScDeg(getRelatedScaleDegree(previous.getScDeg(),preferenceLevel));
		keepInversion(cs,previous);
	}
	
	protected static void suggestTonic(ChordSuggestion cs){
		cs.setScDeg(ScaleDegree.Tonic);
		cs.setChordVariation(ChordVariation.P5);
	}
	
	protected static void suggestDominant(ChordSuggestion cs){
		cs.setScDeg(ScaleDegree.Dominant);
		cs.setChordVariation(ChordVariation.P5);
	}
	protected static void suggestDominantTC2(ChordSuggestion cs){
		cs.setScDeg(ScaleDegree.Dominant);
		cs.setChordVariation(ChordVariation.P2);
	}
	/*
	 * Defines the relationships between ScaleDegrees 
	 * (e.g. Tonic -> Tonic is the preferred joining, Tonic -> Subdominant is second best,
	 * in cases where neither is feasible third best option is Tonic -> Dominant
	 */
	private static ScaleDegree getRelatedScaleDegree(ScaleDegree scDeg, int level){
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
					return ScaleDegree.Supertonic;//Just for the sake of consistency...
				case Supertonic:
					return ScaleDegree.Subtonic;//Just for the sake of consistency...
				case Tonic:
					return ScaleDegree.Supertonic;
				default:
					return scDeg;	
				}					
			default: return scDeg;
		}
	}
}
