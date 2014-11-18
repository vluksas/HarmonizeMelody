package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Note;
import harmonizator.NoteFactory;
import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.TonalityType;

public class TrichordFactory implements ChordFactory{

	@Override
	public Chord getChord(ChordInfo data) {
		// TODO Auto-generated method stub
		Chord result = null;
		Note base = NoteFactory.getNote(data.getOctId(),
				data.getTonality(), data.getScDegree(),
				data.getScale(),data.getChordPos());
		data.setAlteration(defineTrichordAlteration(
				TonalityType.isMajor(data.getTonality()),data.getScDegree(),
				data.getScale()));
		switch(data.getChordPos()){
		case Fifth:
			result = new Trichord64(data.getTonality(),data.getScDegree(),
					data.getAlteration(),base,
					data.getTopPos(),data.isWide(),data.isCadential());
			break;
		case Prime:
			result = new Trichord(data.getTonality(),data.getScDegree(),
					data.getAlteration(),base,data.getTopPos(),
					data.getDoubledPos(),data.isWide());
			break;
		case Third:
			result = new Trichord6(data.getTonality(),data.getScDegree(),
					data.getAlteration(),base,data.getTopPos(),
					data.getDoubledPos(),data.isWide(),data.isNoUnison());
			break;
		default:
			break;
		
		}
		return result;
	}
	
	private Alteration defineTrichordAlteration(boolean isMajor, ScaleDegree scDeg, Scale scale){
		switch(scDeg){
		case Tonic:
			if(isMajor){
				return Alteration.Major;
			}else{
				return Alteration.Minor;
			}
		case Supertonic:
			if(isMajor){
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.Diminished;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.Minor;
				}else{
					return Alteration.Diminished;
				}
			}
		case Mediant:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.Diminished;
				}else{
					return Alteration.Minor;
				}
			}else{
				if(scale == Scale.Natural){
					return Alteration.Major;
				}else{
					return Alteration.Augmented;
				}
			}
		case Subdominant:
			if(isMajor){
				if(scale == Scale.Natural){
					return Alteration.Major;
				}else{
					return Alteration.Minor;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.Major;
				}else{
					return Alteration.Minor;
				}
			}
		case Dominant:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.Minor;
				}else{
					return Alteration.Major;
				}
			}else{
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.Major;
				}
			}
		case Submediant:
			if(isMajor){
				if(scale == Scale.Natural){
					return Alteration.Minor;
				}else{
					return Alteration.Augmented;
				}
			}else{
				if(scale == Scale.Melodic){
					return Alteration.Diminished;
				}else{
					return Alteration.Major;
				}
			}
		case Subtonic:
			if(isMajor){
				if(scale == Scale.Melodic){
					return Alteration.Major;
				}else{
					return Alteration.Diminished;
				}
			}else{
				if(scale == Scale.Natural){
					return Alteration.Major;
				}else{
					return Alteration.Diminished;
				}
			}
			
		default:
			return Alteration.Major;
		
		}
	}

}
