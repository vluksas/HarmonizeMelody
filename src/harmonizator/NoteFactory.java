package harmonizator;

import harmonizator.Chords.ChordPosition;

public class NoteFactory {
	public static Note getNote(int octId,Tonality t, ScaleDegree scDeg){
		Note result = new Note(octId*12);
		result = getNoteByTonality(result,t,scDeg);
		if(result.getId() > ((octId+1)*12)){
			result.incrementId(-12);
		} 
		return result;
	}
	
	public static Note getNote(int octId,Tonality t, ScaleDegree scDeg, Scale sc, ChordPosition basePos){
		Note result = getNote(octId,t,scDeg);
		result.incrementId(scIncr(scDeg,sc,TonalityType.isMajor(t)));
		result.incrementId(notePositionIncr(basePos));
		if(result.getId() > ((octId+1)*12)){
			result.incrementId(-12);
		} 
		return result;
	}
	
	private static Note getNoteByTonality(Note result, Tonality t, ScaleDegree scDeg){
		switch(t){
		case CMajor:
			result.incrementId(1+scDegIncr(scDeg,true));
			break;
		case CMinor:
			result.incrementId(1+scDegIncr(scDeg,false));
			break;
		case CsharpMajor:
			result.incrementId(2+scDegIncr(scDeg,true));
			break;
		case CsharpMinor:
			result.incrementId(2+scDegIncr(scDeg,false));
			break;
		case DMajor:
			result.incrementId(3+scDegIncr(scDeg,true));
			break;
		case DMinor:
			result.incrementId(3+scDegIncr(scDeg,false));
			break;
		case DsharpMinor:
			result.incrementId(4+scDegIncr(scDeg,false));
			break;
		case DflatMajor:
			result.incrementId(2+scDegIncr(scDeg,true));
			break;
		case EMajor:
			result.incrementId(5+scDegIncr(scDeg,true));
			break;
		case EMinor:
			result.incrementId(5+scDegIncr(scDeg,false));
			break;
		case EflatMajor:
			result.incrementId(4+scDegIncr(scDeg,true));
			break;
		case EflatMinor:
			result.incrementId(4+scDegIncr(scDeg,false));
			break;
		case FMajor:
			result.incrementId(6+scDegIncr(scDeg,true));
			break;
		case FMinor:
			result.incrementId(6+scDegIncr(scDeg,false));
			break;
		case FsharpMajor:
			result.incrementId(7+scDegIncr(scDeg,true));
			break;
		case FsharpMinor:
			result.incrementId(7+scDegIncr(scDeg,false));
			break;
		case GMajor:
			result.incrementId(8+scDegIncr(scDeg,true));
			break;
		case GMinor:
			result.incrementId(8+scDegIncr(scDeg,false));
			break;
		case GsharpMinor:
			result.incrementId(9+scDegIncr(scDeg,false));
			break;
		case AMajor:
			result.incrementId(10+scDegIncr(scDeg,true));
			break;
		case AMinor:
			result.incrementId(10+scDegIncr(scDeg,false));
			break;	
		case AsharpMinor:
			result.incrementId(11+scDegIncr(scDeg,false));
			break;
		case AflatMajor:
			result.incrementId(9+scDegIncr(scDeg,true));
			break;
		case AflatMinor:
			result.incrementId(9+scDegIncr(scDeg,false));
			break;
		case HMajor:
			result.incrementId(12+scDegIncr(scDeg,true));
			break;
		case HMinor:
			result.incrementId(12+scDegIncr(scDeg,false));
			break;	
		case BMajor:
			result.incrementId(11+scDegIncr(scDeg,true));
			break;
		case BMinor:
			result.incrementId(11+scDegIncr(scDeg,false));
			break;
		default: return null;
				
		}
		return result;
	}
	
	private static int scDegIncr(ScaleDegree scDeg, boolean isMajor){//alter note by it's scale degree
		switch(scDeg){
			case Tonic: return 0;
			case Supertonic: return 2;
			case Mediant: 
				if(isMajor){
					return 4;
				}else{
					return 3;					
				}
			case Subdominant: return 5;
			case Dominant: return 7;
			case Submediant:
				if(isMajor){
					return 9;
				}else{
					return 8;					
				}
			case Subtonic:
				if(isMajor){
					return 11;
				}else{
					return 10;					
				}
			default: return -1;
		}
	}
	
	private static int scIncr(ScaleDegree scDeg, Scale sc,boolean isMajor){//alter note by it's scale
		if(scDeg == ScaleDegree.Submediant && sc == Scale.Melodic && !isMajor){
			return 1;
		}
		if(scDeg == ScaleDegree.Submediant && (sc == Scale.Melodic || sc == Scale.Harmonic) && isMajor){
			return -1;
		}
		if(scDeg == ScaleDegree.Subtonic && (sc == Scale.Melodic || sc == Scale.Harmonic) && !isMajor){
			return 1;
		}
		if(scDeg == ScaleDegree.Subtonic && sc == Scale.Melodic && isMajor){
			return -1;
		}
		return 0;
		
	}
	
	private static int notePositionIncr(ChordPosition cp){
		switch(cp){
		case Fifth:
			return 7;
		case Seventh:
			return 11;
		case Third:
			return 4;
		default:
			return 0;
		
		}
	}
}
