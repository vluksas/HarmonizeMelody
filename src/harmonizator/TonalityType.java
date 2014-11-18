package harmonizator;

public class TonalityType {
	
	public static boolean isMajor(Tonality t){
		switch(t){
		case AMajor:
			return true;
		case AMinor:
			return false;
		case AflatMajor:
			return true;
		case AflatMinor:
			return false;
		case AsharpMinor:
			return false;
		case BMajor:
			return true;
		case BMinor:
			return false;
		case CMajor:
			return true;
		case CMinor:
			return false;
		case CsharpMajor:
			return true;
		case CsharpMinor:
			return false;
		case DMajor:
			return true;
		case DMinor:
			return false;
		case DflatMajor:
			return true;
		case DsharpMinor:
			return false;
		case EMajor:
			return true;
		case EMinor:
			return false;
		case EflatMajor:
			return true;
		case EflatMinor:
			return false;
		case FMajor:
			return true;
		case FMinor:
			return false;
		case FsharpMajor:
			return true;
		case FsharpMinor:
			return false;
		case GMajor:
			return true;
		case GMinor:
			return false;
		case GsharpMinor:
			return false;
		case HMajor:
			return true;
		case HMinor:
			return false;
		default:
			return false;
		
		}
	}
	
	public static Note getTonic(Tonality t){
		switch(t){
		case AMajor:
			return new Note(10);
		case AMinor:
			return new Note(10);
		case AflatMajor:
			return new Note(9);
		case AflatMinor:
			return new Note(9);
		case AsharpMinor:
			return new Note(11);
		case BMajor:
			return new Note(11);
		case BMinor:
			return new Note(11);
		case CMajor:
			return new Note(1);
		case CMinor:
			return new Note(1);
		case CsharpMajor:
			return new Note(2);
		case CsharpMinor:
			return new Note(2);
		case DMajor:
			return new Note(3);
		case DMinor:
			return new Note(3);
		case DflatMajor:
			return new Note(2);
		case DsharpMinor:
			return new Note(4);
		case EMajor:
			return new Note(5);
		case EMinor:
			return new Note(5);
		case EflatMajor:
			return new Note(4);
		case EflatMinor:
			return new Note(4);
		case FMajor:
			return new Note(6);
		case FMinor:
			return new Note(6);
		case FsharpMajor:
			return new Note(7);
		case FsharpMinor:
			return new Note(7);
		case GMajor:
			return new Note(8);
		case GMinor:
			return new Note(8);
		case GsharpMinor:
			return new Note(9);
		case HMajor:
			return new Note(12);
		case HMinor:
			return new Note(12);
		default:
			return null;
		
		}
	}
	
	public static Note getTonic(Tonality t,int octId){
		switch(t){
		case AMajor:
			return new Note(10+octId*12);
		case AMinor:
			return new Note(10+octId*12);
		case AflatMajor:
			return new Note(9+octId*12);
		case AflatMinor:
			return new Note(9+octId*12);
		case AsharpMinor:
			return new Note(11+octId*12);
		case BMajor:
			return new Note(11+octId*12);
		case BMinor:
			return new Note(11+octId*12);
		case CMajor:
			return new Note(1+octId*12);
		case CMinor:
			return new Note(1+octId*12);
		case CsharpMajor:
			return new Note(2+octId*12);
		case CsharpMinor:
			return new Note(2+octId*12);
		case DMajor:
			return new Note(3+octId*12);
		case DMinor:
			return new Note(3+octId*12);
		case DflatMajor:
			return new Note(2+octId*12);
		case DsharpMinor:
			return new Note(4+octId*12);
		case EMajor:
			return new Note(5+octId*12);
		case EMinor:
			return new Note(5+octId*12);
		case EflatMajor:
			return new Note(4+octId*12);
		case EflatMinor:
			return new Note(4+octId*12);
		case FMajor:
			return new Note(6+octId*12);
		case FMinor:
			return new Note(6+octId*12);
		case FsharpMajor:
			return new Note(7+octId*12);
		case FsharpMinor:
			return new Note(7+octId*12);
		case GMajor:
			return new Note(8+octId*12);
		case GMinor:
			return new Note(8+octId*12);
		case GsharpMinor:
			return new Note(9+octId*12);
		case HMajor:
			return new Note(12+octId*12);
		case HMinor:
			return new Note(12+octId*12);
		default:
			return null;
		
		}
	}
}
