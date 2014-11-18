package harmonizator.Chords;

import harmonizator.Alteration;
import harmonizator.Scale;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;

public class ChordInfo {
	private ChordPosition chordPos;
	private Tonality tonality;
	private Scale scale;
	private ChordPosition doubledPos;
	private Alteration alteration;
	private ChordPosition topPos;
	private ScaleDegree scDegree;
	private int octId;
	private boolean wide;
	private boolean noUnison;// Used for Trichord6 to get a variation without unison in the top 3 voices in
	//wide with the prime on top and doubled and narrow with the fifth on top and doubled layouts
	private boolean isCadential; // Only relevant for constructing six-four chords. Notes whether the chord
	//is cadential or passing/pedal.
	
	public ChordInfo(ChordPosition chordPos, Tonality tonality, Scale scale,
			ChordPosition doubledPos, ChordPosition topPos,
			ScaleDegree scDegree, int octId, boolean wide, boolean noUnison, boolean isCadential) {
		super();
		this.chordPos = chordPos;
		this.tonality = tonality;
		this.scale = scale;
		this.doubledPos = doubledPos;
		this.topPos = topPos;
		this.scDegree = scDegree;
		this.octId = octId;
		this.wide = wide;
		this.noUnison = noUnison;
		this.setCadential(isCadential);
	}
	
	public ChordInfo(ChordPosition chordPos, Tonality tonality, Scale scale,
			ChordPosition doubledPos, ChordPosition topPos,
			ScaleDegree scDegree, int octId, boolean wide, boolean noUnison) {
		super();
		this.chordPos = chordPos;
		this.tonality = tonality;
		this.scale = scale;
		this.doubledPos = doubledPos;
		this.topPos = topPos;
		this.scDegree = scDegree;
		this.octId = octId;
		this.wide = wide;
		this.noUnison = noUnison;
		this.setCadential(false);
	}
	
	public ChordInfo(ChordPosition chordPos, Tonality tonality, Scale scale,
			ChordPosition doubledPos, ChordPosition topPos,
			ScaleDegree scDegree, int octId, boolean wide) {
		super();
		this.chordPos = chordPos;
		this.tonality = tonality;
		this.scale = scale;
		this.doubledPos = doubledPos;
		this.topPos = topPos;
		this.scDegree = scDegree;
		this.octId = octId;
		this.wide = wide;
		this.noUnison = false;
		this.setCadential(false);
	}
	
	public ChordInfo(ChordPosition chordPos, Tonality tonality,
			ChordPosition doubledPos, ChordPosition topPos,
			ScaleDegree scDegree, int octId, boolean wide) {
		super();
		this.chordPos = chordPos;
		this.tonality = tonality;
		this.scale = Scale.Natural;
		this.doubledPos = doubledPos;
		this.topPos = topPos;
		this.scDegree = scDegree;
		this.octId = octId;
		this.wide = wide;
		this.setCadential(false);
	}
	
	public ChordPosition getChordPos() {
		return chordPos;
	}
	
	public void setChordPos(ChordPosition chordPos) {
		this.chordPos = chordPos;
	}
	
	public Tonality getTonality() {
		return tonality;
	}
	
	public void setTonality(Tonality tonality) {
		this.tonality = tonality;
	}
	
	public ChordPosition getDoubledPos() {
		return doubledPos;
	}
	
	public void setDoubledPos(ChordPosition doubledPos) {
		this.doubledPos = doubledPos;
	}
	
	public Alteration getAlteration() {
		return alteration;
	}
	
	public void setAlteration(Alteration alteration) {
		this.alteration = alteration;
	}
	
	public ChordPosition getTopPos() {
		return topPos;
	}
	
	public void setTopPos(ChordPosition topPos) {
		this.topPos = topPos;
	}
	
	public ScaleDegree getScDegree() {
		return scDegree;
	}
	
	public void setScDegree(ScaleDegree scDegree) {
		this.scDegree = scDegree;
	}
	
	public int getOctId() {
		return octId;
	}
	
	public void setOctId(int octId) {
		this.octId = octId;
	}
	
	public boolean isWide() {
		return wide;
	}
	
	public void setWide(boolean wide) {
		this.wide = wide;
	}
	
	public Scale getScale() {
		return scale;
	}
	
	public void setScale(Scale scale) {
		this.scale = scale;
	}

	public boolean isNoUnison() {
		return noUnison;
	}

	public void setNoUnison(boolean noUnison) {
		this.noUnison = noUnison;
	}
	
	public boolean isCadential() {
		return isCadential;
	}
	
	public void setCadential(boolean isCadential) {
		this.isCadential = isCadential;
	}
	
}
