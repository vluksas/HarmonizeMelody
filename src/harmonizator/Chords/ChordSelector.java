package harmonizator.Chords;


import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.TonalityType;

public class ChordSelector {
	private static final int DEFAULT_OCT_ID = 3;
	private ChordInfo chordToBuild = null;
	private ChordFactory cf5;
	private ChordFactory cf7;
	public ChordSelector(){
		cf5 = new TrichordFactory();
		cf7 = new TetrachordFactory();
		reset();
	}
	
	public ChordSelector(Tonality t){
		cf5 = new TrichordFactory();
		cf7 = new TetrachordFactory();
		reset(t);
	}
	
	public ChordSelector(Tonality t,Scale sc){
		cf5 = new TrichordFactory();
		cf7 = new TetrachordFactory();
		reset(t,sc);
	}
	
	public Chord buildChord(){
		if(defineChordType() == ChordType.Trichord){
			return cf5.getChord(chordToBuild);
		}else{
			return cf7.getChord(chordToBuild);
		}
	}
	
	public ChordInfo getChordToBuildData() {
		return chordToBuild;
	}
	
	public void selectTonality(Tonality t){
		chordToBuild.setTonality(t);
	}
	
	public void selectTonality(Tonality t, boolean retainScale){//To get most commonly used scale
		if(!retainScale){
			if(TonalityType.isMajor(t)){
				selectScale(Scale.Natural);
			}else{
				selectScale(Scale.Harmonic);				
			}
		}
		chordToBuild.setTonality(t);
	}
	
	public void selectScale(Scale sc){
		chordToBuild.setScale(sc);
	}
	
	private ChordType defineChordType(){
		if(chordToBuild.getChordPos() == ChordPosition.Seventh ||
				chordToBuild.getDoubledPos() == ChordPosition.Seventh ||
				chordToBuild.getTopPos() == ChordPosition.Seventh ||
				chordToBuild.getDoubledPos() == null){
			return ChordType.Tetrachord;
		}else{
			return ChordType.Trichord;
		}
	}
	
	public void selectX5(){//Any trichord of base position
		chordToBuild.setChordPos(ChordPosition.Prime);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectT5(){
		chordToBuild.setScDegree(ScaleDegree.Tonic);
		chordToBuild.setChordPos(ChordPosition.Prime);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectT6(){
		chordToBuild.setScDegree(ScaleDegree.Tonic);
		chordToBuild.setChordPos(ChordPosition.Third);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectT64(){
		chordToBuild.setScDegree(ScaleDegree.Tonic);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		chordToBuild.setDoubledPos(ChordPosition.Fifth);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectK64(){
		chordToBuild.setScDegree(ScaleDegree.Tonic);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		setDoubledPosPreference(ChordType.Trichord);
		selectCadential();
	}
	
	public void selectS5(){
		chordToBuild.setScDegree(ScaleDegree.Subdominant);
		chordToBuild.setChordPos(ChordPosition.Prime);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectS6(){
		chordToBuild.setScDegree(ScaleDegree.Subdominant);
		chordToBuild.setChordPos(ChordPosition.Third);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectS64(){
		chordToBuild.setScDegree(ScaleDegree.Subdominant);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectD5(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Prime);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectD6(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Third);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectD64(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		setDoubledPosPreference(ChordType.Trichord);
	}
	
	public void selectD7(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Prime);
		if(chordToBuild.getTopPos() == ChordPosition.Prime){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord);
	}
	
	public void selectD56(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Third);
		if(chordToBuild.getTopPos() == ChordPosition.Third){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord);
	}
	
	public void selectD34(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		if(chordToBuild.getTopPos() == ChordPosition.Fifth){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord); 
	}
	
	public void selectD2(){
		chordToBuild.setScDegree(ScaleDegree.Dominant);
		chordToBuild.setChordPos(ChordPosition.Seventh);
		if(chordToBuild.getTopPos() == ChordPosition.Seventh){
			chordToBuild.setTopPos(ChordPosition.Prime);
		}
		setDoubledPosPreference(ChordType.Tetrachord); 
	}
	
	public void selectII7(){
		chordToBuild.setScDegree(ScaleDegree.Supertonic);
		chordToBuild.setChordPos(ChordPosition.Prime);
		if(chordToBuild.getTopPos() == ChordPosition.Prime){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord);
	}
	
	public void selectII56(){
		chordToBuild.setScDegree(ScaleDegree.Supertonic);
		chordToBuild.setChordPos(ChordPosition.Third);
		if(chordToBuild.getTopPos() == ChordPosition.Third){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord);
	}
	
	public void selectII34(){
		chordToBuild.setScDegree(ScaleDegree.Supertonic);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		if(chordToBuild.getTopPos() == ChordPosition.Fifth){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord); 
	}
	
	public void selectII2(){
		chordToBuild.setScDegree(ScaleDegree.Supertonic);
		chordToBuild.setChordPos(ChordPosition.Seventh);
		if(chordToBuild.getTopPos() == ChordPosition.Seventh){
			chordToBuild.setTopPos(ChordPosition.Prime);
		}
		setDoubledPosPreference(ChordType.Tetrachord); 
	}
	
	public void selectVII7(){
		chordToBuild.setScDegree(ScaleDegree.Subtonic);
		chordToBuild.setChordPos(ChordPosition.Prime);
		if(chordToBuild.getTopPos() == ChordPosition.Prime){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord);
	}
	
	public void selectVII56(){
		chordToBuild.setScDegree(ScaleDegree.Subtonic);
		chordToBuild.setChordPos(ChordPosition.Third);
		if(chordToBuild.getTopPos() == ChordPosition.Third){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord);
	}
	
	public void selectVII34(){
		chordToBuild.setScDegree(ScaleDegree.Subtonic);
		chordToBuild.setChordPos(ChordPosition.Fifth);
		if(chordToBuild.getTopPos() == ChordPosition.Fifth){
			chordToBuild.setTopPos(ChordPosition.Seventh);
		}
		setDoubledPosPreference(ChordType.Tetrachord); 
	}
	
	public void selectVII2(){
		chordToBuild.setScDegree(ScaleDegree.Subtonic);
		chordToBuild.setChordPos(ChordPosition.Seventh);
		if(chordToBuild.getTopPos() == ChordPosition.Seventh){
			chordToBuild.setTopPos(ChordPosition.Prime);
		}
		setDoubledPosPreference(ChordType.Tetrachord); 
	}
	
	public void selectWideness(boolean isWide){
		chordToBuild.setWide(isWide); 
	}
	
	public void selectWide(){
		chordToBuild.setWide(true); 
	}
	
	public void selectNarrow(){
		chordToBuild.setWide(false); 
	}
	
	public void selectTopPos(ChordPosition cp){
		chordToBuild.setTopPos(cp); 
	}
	
	public void selectLayout(boolean isWide,ChordPosition cp){
		selectWideness(isWide);
		selectTopPos(cp);
	}
	
	public void selectOct(int octId){
		if(octId > -1 && octId < 9){
			chordToBuild.setOctId(octId);
		}else{
			chordToBuild.setOctId(DEFAULT_OCT_ID);
		}
	}
	
	public void selectScaleDegree(ScaleDegree scDeg){
		chordToBuild.setScDegree(scDeg);
	}
	
	public void selectScaleDegree(int scDeg){
		switch(scDeg){
			case 1: chordToBuild.setScDegree(ScaleDegree.Tonic);break;
			case 2: chordToBuild.setScDegree(ScaleDegree.Supertonic);break;
			case 3: chordToBuild.setScDegree(ScaleDegree.Mediant);break;
			case 4: chordToBuild.setScDegree(ScaleDegree.Subdominant);break;
			case 5: chordToBuild.setScDegree(ScaleDegree.Dominant);break;
			case 6: chordToBuild.setScDegree(ScaleDegree.Submediant);break;
			case 7: chordToBuild.setScDegree(ScaleDegree.Subtonic);break;
			default: break;
		}
	} 
	
	public void reset(){
		chordToBuild = new ChordInfo(ChordPosition.Prime, Tonality.CMajor,
				ChordPosition.Prime, ChordPosition.Prime,
				ScaleDegree.Tonic, DEFAULT_OCT_ID, false);
	}
	
	public void reset(Tonality t){//Forces default scale
		chordToBuild = new ChordInfo(ChordPosition.Prime, t,
				ChordPosition.Prime, ChordPosition.Prime,
				ScaleDegree.Tonic, DEFAULT_OCT_ID, false);
		if(TonalityType.isMajor(t)){
			selectScale(Scale.Natural);
		}else{
			selectScale(Scale.Harmonic);				
		}
	}
	
	public void reset(Tonality t,Scale sc){
		chordToBuild = new ChordInfo(ChordPosition.Prime, t,sc,
				ChordPosition.Prime, ChordPosition.Prime,
				ScaleDegree.Tonic, DEFAULT_OCT_ID, false);
	}
	
	public void selectNoUnisonOpt(boolean forceNoUnison){
		chordToBuild.setNoUnison(forceNoUnison);
	}
	
	public void selectUnisonPrefered(){
		chordToBuild.setNoUnison(true);
	}
	
	public void selectNoUnisonPrefered(){
		chordToBuild.setNoUnison(false);
	}
	
	public void selectCadential(){
		chordToBuild.setCadential(true);
	}
	
	public void selectNonCadential(){
		chordToBuild.setCadential(false);
	}
	public void selectDoubledPos(ChordPosition cp){
		chordToBuild.setDoubledPos(cp);
	}
	
	private void setDoubledPosPreference(ChordType ct){
		if(ct == ChordType.Trichord){
			if(chordToBuild.getDoubledPos() == null){
				chordToBuild.setDoubledPos(ChordPosition.Prime);
			}
		}else if(ct == ChordType.Tetrachord){
			if(chordToBuild.getDoubledPos() != null){
				chordToBuild.setDoubledPos(null);
			}
		}
	}
	
	public void raiseOct(int amount){
		chordToBuild.setOctId(chordToBuild.getOctId()+amount);
	}
	
	public void lowerOct(int amount){
		chordToBuild.setOctId(chordToBuild.getOctId()-amount);
	}
	
	public void raiseOct(){
		raiseOct(1);
	}
	
	public void lowerOct(){
		lowerOct(1);
	}
	
	public Tonality getTonality(){
		return chordToBuild.getTonality();
	}
	
}
