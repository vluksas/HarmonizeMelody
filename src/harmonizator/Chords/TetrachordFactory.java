package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.NoteFactory;
import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.TonalityType;

public class TetrachordFactory implements ChordFactory{

	@Override
	public Chord getChord(ChordInfo data) {
		Chord result = null;
		Note base = NoteFactory.getNote(data.getOctId(),
				data.getTonality(), data.getScDegree(),
				data.getScale(),data.getChordPos());
		data.setAlteration(defineTetrachordAlteration(
				TonalityType.isMajor(data.getTonality()),data.getScDegree(),
				data.getScale()));
		switch(data.getChordPos()){
			case Fifth:
				result = new Tetrachord34(data.getTonality(),data.getScDegree(),
						data.getAlteration(),base,data.getTopPos(),
						data.isWide());
				break;
			case Prime:
				result = new Tetrachord(data.getTonality(),data.getScDegree(),
						data.getAlteration(),base,data.getTopPos(),
						data.isWide());
				break;
			case Seventh:
				result = new Tetrachord2(data.getTonality(),data.getScDegree(),
						data.getAlteration(),base,data.getTopPos(),
						data.isWide());
				break;
			case Third:
				result = new Tetrachord56(data.getTonality(),data.getScDegree(),
						data.getAlteration(),base,data.getTopPos(),
						data.isWide());
				break;
			default:
				break;
		
		}
		return result;
	}

	private Alteration defineTetrachordAlteration(boolean isMajor,
			ScaleDegree scDeg, Scale scale) {
		switch(scDeg){
		case Tonic:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.Dominant;
				}else{
					return Alteration.Major;
				}
			}else{
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.MinorMajor;
				}
			}
		case Supertonic:
			if(isMajor){
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.HalfDiminished;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.Minor;
				}else{
					return Alteration.HalfDiminished;
				}
			}
		case Mediant:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.HalfDiminished;
				}else{
					return Alteration.Minor;
				}
			}else{
				if(scale == Scale.Natural){
					return Alteration.Major;
				}else{
					return Alteration.AugmentedMajor;
				}
			}
		case Subdominant:
			if(isMajor){
				if(scale == Scale.Natural){
					return Alteration.Major;
				}else{
					return Alteration.MinorMajor;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.Dominant;
				}else{
					return Alteration.Minor;
				}
			}
		case Dominant:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.Minor;
				}else{
					return Alteration.Dominant;
				}
			}else{
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.Dominant;
				}
			}
		case Submediant:
			if(isMajor){
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.AugmentedMajor;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.HalfDiminished;
				}else{
					return Alteration.Major;
				}
			}
		case Subtonic:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.Dominant;
				}else if(scale == Scale.Harmonic){
					return Alteration.Diminished;
				}else{
					return Alteration.HalfDiminished;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.HalfDiminished;
				}else if(scale == Scale.Harmonic){
					return Alteration.Diminished;
				}else{
					return Alteration.Dominant;
				}
			}
			
		default:
			return Alteration.Major;
		
		}
	}

}
