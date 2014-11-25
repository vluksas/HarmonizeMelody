package harmonizator.Solver;

import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Tonality;
import harmonizator.TonalityType;
import harmonizator.Chords.Chord;
import harmonizator.Chords.ChordGeneric;
import harmonizator.Chords.ChordPosition;
import harmonizator.Chords.ChordSelector;
import harmonizator.Rules.RuleSet;
import harmonizator.Solver.ChordTypePicker.ChordTypePicker;
import harmonizator.Solver.ChordTypePicker.ChordTypePickerGeneral;
import harmonizator.Solver.ChordTypePicker.*;

import java.util.ArrayList;

public class Solver {
	private static final int NUM_OF_SOLUTION_VARIATIONS = 2;
	private ArrayList<Note> melody;
	private ArrayList<Chord> harmony;
	private ChordSelector cb;
	private boolean preferWide = false; 
	private ChordTypePicker chordTP;
	private ChordSuggestor csug;
	private int notesSolved;


	public Solver(){
		melody = new ArrayList<Note>();
		harmony = new ArrayList<Chord>();
		cb = new ChordSelector();
		notesSolved = 0;
		chordTP = ChordTypePickerGeneral.buildBaseTree();
		setBaseChords();
		csug = new ChordSuggestor();
	}
	public Solver(int meterTopN,int meterBottomN){
		melody = new ArrayList<Note>();
		harmony = new ArrayList<Chord>();
		cb = new ChordSelector();
		chordTP = ChordTypePickerGeneral.buildBaseTree();
		setBaseChords();
		csug = new ChordSuggestor(meterTopN,meterBottomN);
	}
	public Solver(int meterTopN,int meterBottomN,Tonality t){
		melody = new ArrayList<Note>();
		harmony = new ArrayList<Chord>();
		cb = new ChordSelector(t);
		chordTP = ChordTypePickerGeneral.buildBaseTree();
		setBaseChords();
		csug = new ChordSuggestor(meterTopN,meterBottomN);
	}

	public void addToAvailableChords(ChordTypePicker ctp){
		chordTP.add(ctp);
	}
	public void addToAvailableChords(Iterable<ChordTypePicker> ctps){
		for(ChordTypePicker ctp:ctps){
			chordTP.add(ctp);
		}
	}
	private void setBaseChords(){
		chordTP.add(new T5Picker());
		chordTP.add(new S5Picker());
		chordTP.add(new D5Picker());
	}
	/*
	 * Gets next note of the melody (used in the solution process)
	 * updateChordSuggestor tells whether ChordSuggestor or not
	 */
	private Note getNextMelodyNote(int index,boolean updateChordSuggestor){
		Note result = melody.get(index);
		if(updateChordSuggestor){
			csug.updatePositionInBar(result.getNoteValue());
		}
		return result;
	}
	/*
	 * Gets next note of the melody (used in the solution process)
	 */
	private Note getNextMelodyNote(int index){
		Note result = melody.get(index);
		csug.updatePositionInBar(result.getNoteValue());
		return result;
	}

	public void addNote(Note n){
		melody.add(n);
	}
	public ArrayList<Note> getMelody() {
		return melody;
	}

	public void setMelody(ArrayList<Note> melody) {
		this.melody = melody;
	}
	public ArrayList<Chord> getHarmony() {
		return harmony;
	}
	/*
	 * Harmonizes the melody given in melody arraylist and saves the solution in harmony arraylist
	 * Tries both wide and narrow preference
	 */
	public ArrayList<Chord> solve(){
		//preparation
		ArrayList<Chord> temp_best_harmony = new ArrayList<Chord>();
		//---------
		for(int i = 0;i < NUM_OF_SOLUTION_VARIATIONS;i++){
			solve(i);
			if(melody.size() == harmony.size()){
				return this.harmony;
			}else{
				if(harmony.size() > temp_best_harmony.size()){
					temp_best_harmony = harmony;
					harmony = new ArrayList<Chord>();
				}
			}
		}
		harmony = temp_best_harmony;
		return this.harmony;
	}
	public ArrayList<Chord> solve(int solutionNumber){
		csug.resetBarPosition();
		harmony = new ArrayList<Chord>();
		switch(solutionNumber){
		case 0: 
			preferWide = false;
			break;
		case 1: 
			preferWide = true;
			break;
		default: 
			break;
		}
		csug.resetBarPosition();
		//Harmonize first note
		Note cn = getNextMelodyNote(0,false);
		if(!solveNext(csug,cn,null)){
			return getHarmony();
		}
		for(int i = 1;i < melody.size(); i++){
			//Harmonize by expositional harmony rules
			cn = getNextMelodyNote(i);
			if(!solveNext(csug,cn,harmony.get(i-1))){
				return getHarmony();
			}
		}
		return getHarmony();
	}
	/*
	 * return true if note was successfully harmonized, false otherwise
	 */
	private boolean solveNext(ChordSuggestor cs, Note currentNote, Chord previousChord){
		for(int i = 0;i < cs.getNumOfOpts();i++){
			ChordSuggestion sug = cs.suggest(i, previousChord, currentNote);
			if(sug.isSet()){
				if(attemptToHarmonize(sug,currentNote,previousChord) == true){
					return true;
				}
			}else{
				harmony.add(null);
				return false;
			}

		}
		harmony.add(null);
		return false;
	}

	/*
	 * Attempts to use given suggestion to harmonize next note
	 * returns true in the case of success, false in the case of failure
	 */
	private boolean attemptToHarmonize(ChordSuggestion sug, Note currentNote, Chord previousChord){
		if(harmonizeNote(sug,currentNote,previousChord,preferWide)){
			return true;
		}else if(harmonizeNote(sug,currentNote,previousChord,!preferWide)){
			return true;
		}	
		return false;
	}

	/*
	 * Attempts to use given suggestion to harmonize the given note
	 * also tries to vary bass to find a fitting chord setup
	 */
	private boolean harmonizeNote(ChordSuggestion sug, Note currentNote, Chord previousChord, boolean tryWide){
		Chord c = chordFromSuggestion(sug, currentNote, previousChord,tryWide);
		if(c == null){
			return false;
		}
		if(testCorrectnessOfChord(c,previousChord)){//test correctness of the original chord
			return true;
		}
		int origBassId = c.getNote(ChordGeneric.BOTTOM_CHORD_INDEX).getId();
		c.bassDown();//try to lower the bass by an octave
		if(c.getNote(ChordGeneric.BOTTOM_CHORD_INDEX).getId() != origBassId){//bass lowered
			if(testCorrectnessOfChord(c,previousChord)){//test correctness of a chord with lowered bass
				return true;
			}
			c.bassUp();//restore bass
		}
		c.bassUp();//try to raise the bass by an octave
		if(c.getNote(ChordGeneric.BOTTOM_CHORD_INDEX).getId() != origBassId){//bass raised
			if(testCorrectnessOfChord(c,previousChord)){//test correctness of a chord with raised bass
				return true;
			}
			c.bassDown();//restore bass
		}
		return false;
	}
	/*
	 * Check whether two given chords are joined according to the rules in the rule set
	 */
	private boolean testCorrectnessOfChord(Chord c,Chord previousChord){
		RuleSet rs = RuleSet.getRuleSet();
		int joinResult = rs.correctJoining(previousChord, c);
		if(joinResult == 0){
			harmony.add(c);
			return true;
		}else if(joinResult > 0){
			//Could implement different behavior for non critical mistakes,
			// currently non critical mistakes are ignored
			harmony.add(c);
			return true;
		}
		return false;
	}
	/*
	 * Constructs a chord from given suggestion matching the melody note passed by currentNote argument
	 */
	private Chord chordFromSuggestion(ChordSuggestion sug, Note currentNote, Chord previousChord, boolean tryWide){
		chordTP.pickType(cb, sug);		//Get the type of the chord
		if(!setChordPosition(sug,currentNote)){//Attempts to set the top note of the chord
			return null;
		}

		//Choose wideness

		if(tryWide){
			cb.selectWide();
		}else{
			cb.selectNarrow();
		}

		Chord result = cb.buildChord();
		//Check whether octave is correct
		if(result.getNotes() == null){
			return null;
		}
		if(result.getNote(ChordGeneric.TOP_CHORD_INDEX).getId() != currentNote.getId()){
			if((result.getNote(ChordGeneric.TOP_CHORD_INDEX).getId() - currentNote.getId())%12 == 0){
				adjustOctave(result,currentNote);
			}else{
				return null;
			}
		}
		return result;
	}
	private void adjustOctave(Chord c, Note targetNote){
		while(c.getNote(ChordGeneric.TOP_CHORD_INDEX).getId() < targetNote.getId()){
			c.octaveUp();
			cb.raiseOct();

		}
		while(c.getNote(ChordGeneric.TOP_CHORD_INDEX).getId() > targetNote.getId()){
			c.octaveDown();
			cb.lowerOct();
		}
	}
	/*
	 * Attempts to set the top note of the chord by ChordSuggestion and the note to harmonize
	 * returns true if succeeds, false otherwise
	 */
	private boolean setChordPosition(ChordSuggestion sug, Note currentNote){
		ScaleDegree cnsd = Note.getScaleDegree(currentNote, TonalityType.getTonic(cb.getTonality()));
		if(sug.getScDeg() == ScaleDegree.Tonic){
			switch(cnsd){
			case Tonic:
				cb.selectTopPos(ChordPosition.Prime);
				break;
			case Mediant:
				cb.selectTopPos(ChordPosition.Third);
				break;
			case Dominant:
				cb.selectTopPos(ChordPosition.Fifth);
				break;
			default:
				return false;
			}
		}else if(sug.getScDeg() == ScaleDegree.Subdominant){
			switch(cnsd){
			case Subdominant:
				cb.selectTopPos(ChordPosition.Prime);
				break;
			case Submediant:
				cb.selectTopPos(ChordPosition.Third);
				break;
			case Tonic:
				cb.selectTopPos(ChordPosition.Fifth);
				break;
			default:
				return false;
			}
		}else if(sug.getScDeg() == ScaleDegree.Dominant){
			switch(cnsd){
			case Dominant:
				cb.selectTopPos(ChordPosition.Prime);
				break;
			case Subtonic:
				cb.selectTopPos(ChordPosition.Third);
				break;
			case Supertonic:
				cb.selectTopPos(ChordPosition.Fifth);
				break;
			default:
				return false;
			}
		}else{
			return false;
		}
		return true;

	}
}
