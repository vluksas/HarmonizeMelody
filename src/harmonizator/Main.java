package harmonizator;

import java.util.ArrayList;

import harmonizator.Chords.*;
import harmonizator.Rules.*;
import harmonizator.Solver.Solver;
import harmonizator.Solver.ChordTypePicker.S6Picker;
public class Main { 

	public static void main(String[] args) {
		//tryFifthsRule();
		//tryChordBuilder();
		//reasonForCBAndCF();
		//makeT5Comparsion();
		//trySolvingAMelody();
		
	}
	private static void tryFifthsRule(){
		Rule pf = ParallelFifths.getInstance();
		ChordGeneric CTrichord = new ChordGeneric(new Note(61));
		ChordGeneric ETrichord = new ChordGeneric(new Note(65));
		Note [] cNotes = {new Note(59),new Note(56),new Note(53),new Note(49)};
		ChordGeneric CSept = new ChordGeneric(cNotes);
		//Try out Rules
		System.out.println("Ar nëra kvintø?:");
		System.out.println("C5 ir E5: " + pf.correctJoining(CTrichord, ETrichord));
		System.out.println("C5 ir C7: " + pf.correctJoining(CTrichord, CSept));
		//Try out RuleSet
		RuleSet rules = RuleSet.getRuleSet();
		System.out.println("Ar gerai?:");
		System.out.println("C5 ir E5: " + rules.correctJoining(CTrichord, ETrichord));
		System.out.println("C5 ir C7: " + rules.correctJoining(CTrichord, CSept));
		rules.addRule(ParallelFifths.getInstance());
		System.out.println("Ar dabar gerai?:");
		System.out.println("C5 ir E5: " + rules.correctJoining(CTrichord, ETrichord));
		System.out.println("C5 ir C7: " + rules.correctJoining(CTrichord, CSept));
	}
	private static void tryChordBuilder(){
		ChordSelector cb = new ChordSelector();
		cb.selectS5();
		cb.selectLayout(true, ChordPosition.Third);
		Chord t1 = cb.buildChord();
		System.out.println(t1.toString());
		cb.reset(Tonality.CsharpMinor);
		cb.selectT5();
		Chord t2 = cb.buildChord();
		System.out.println(t2.toString());
		cb.selectWideness(true);
		Chord t3 = cb.buildChord();
		System.out.println(t3.toString());
		cb.selectD5();
		cb.selectTopPos(ChordPosition.Fifth);
		Chord t4 = cb.buildChord(); 
		System.out.println(t4.toString());
		cb.selectD7();
		Chord t5 = cb.buildChord();
		System.out.println(t5.toString());
		System.out.println(((Tetrachord)t5).getSeventhIndex());
	}
	private static void reasonForCBAndCF(){
		//Norime tokios akordø sekos: T5 II2 D56 T5 II34 DD34 K64 D5 T5
		Chord[] chSet = new Chord[9]; 
		ChordSelector cb = new ChordSelector();
		cb.selectT5();
		cb.selectLayout(false, ChordPosition.Third);
		chSet[0] = cb.buildChord();//T5
		cb.selectII2();		
		chSet[1] = cb.buildChord();//II2
		cb.selectD56();		
		cb.selectLayout(true, ChordPosition.Seventh);
		cb.lowerOct();
		chSet[2] = cb.buildChord();//D56
		cb.selectT5();
		cb.selectLayout(false, ChordPosition.Third);
		cb.raiseOct();
		chSet[3] = cb.buildChord();//T5
		cb.selectII34();
		cb.selectLayout(true, ChordPosition.Prime);
		cb.lowerOct();
		chSet[4] = cb.buildChord();//II34
		//DD34 nëra...
		cb.selectTonality(Tonality.GMajor);
		cb.selectD34();
		cb.selectLayout(true, ChordPosition.Prime);
		chSet[5] = cb.buildChord();//DD34 hack'as
		cb.reset();
		cb.lowerOct();
		cb.selectK64();
		cb.selectLayout(false, ChordPosition.Third);
		chSet[6] = cb.buildChord();//K64
		cb.selectD5();
		cb.selectLayout(false, ChordPosition.Fifth);
		chSet[7] = cb.buildChord();//D5
		cb.selectT5();
		cb.selectLayout(false, ChordPosition.Third);
		chSet[8] = cb.buildChord();//T5
		for(Chord ch:chSet){
			System.out.println(ch);
		}
		
		
		
	}
	private static void makeT5Comparsion(){
		//1.From notes:
		Note[] notes = {new Note(53),new Note(49),new Note(44),new Note(37)};
		Chord T5c1 = new ChordGeneric(notes);
		System.out.println("Straight from notes: " + T5c1.toString());
		//2.Directly by Trichord constructor:
		Chord T5c2 = new Trichord(Tonality.CMajor,ScaleDegree.Tonic,Alteration.Major,
				new Note(37),ChordPosition.Third,ChordPosition.Prime,false);
		System.out.println("Through constructor: " + T5c2.toString());
		//3.Trichord Factory:
		ChordFactory cf = new TrichordFactory();
		ChordInfo ci = new ChordInfo(ChordPosition.Prime, Tonality.CMajor,
				ChordPosition.Prime, ChordPosition.Third,
				ScaleDegree.Tonic, 3, false);
		Chord T5c3 = cf.getChord(ci);
		System.out.println("Through factory: " + T5c3.toString());
		//4.By ChordSelector Facade:
		ChordSelector cb = new ChordSelector();
		cb.selectT5();
		cb.selectLayout(false, ChordPosition.Third);
		Chord T5c4 = cb.buildChord();
		System.out.println("Through facade: " + T5c4.toString());
	}
	private static void trySolvingAMelodyFull(){
		//set up the rules
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		rs.addRule(ParallelOctaves.getInstance());
		rs.addRule(AllVoicesUp.getInstance());
		rs.addRule(AllVoicesDown.getInstance());
		//Create a solver
		Solver s = new Solver();//uses three basic chords: T5 S5 and D5
		//Create a melody:
		Note[] melodyNotes = new Note[42];
		melodyNotes[0] = new Note(56);
		melodyNotes[0].setVal(NoteValue.Eighth);
		melodyNotes[1] = new Note(56);
		melodyNotes[1].setVal(NoteValue.Eighth);
		melodyNotes[2] = new Note(53);
		melodyNotes[2].setVal(NoteValue.Eighth);
		melodyNotes[3] = new Note(49);
		melodyNotes[3].setVal(NoteValue.Eighth);
		
		melodyNotes[4] = new Note(56);
		melodyNotes[4].setVal(NoteValue.Eighth);
		melodyNotes[5] = new Note(56);
		melodyNotes[5].setVal(NoteValue.Eighth);
		melodyNotes[6] = new Note(53);
		melodyNotes[6].setVal(NoteValue.Eighth);
		melodyNotes[7] = new Note(49);
		melodyNotes[7].setVal(NoteValue.Eighth);
		
		melodyNotes[8] = new Note(54);
		melodyNotes[8].setVal(NoteValue.Eighth);
		melodyNotes[9] = new Note(58);
		melodyNotes[9].setVal(NoteValue.Eighth);
		melodyNotes[10] = new Note(61);
		melodyNotes[10].setVal(NoteValue.Eighth);
		melodyNotes[11] = new Note(58);
		melodyNotes[11].setVal(NoteValue.Eighth);
		
		melodyNotes[12] = new Note(56);
		melodyNotes[13] = new Note(56);
		
		melodyNotes[14] = new Note(54);
		melodyNotes[14].setVal(NoteValue.Eighth);
		melodyNotes[15] = new Note(58);
		melodyNotes[15].setVal(NoteValue.Eighth);
		melodyNotes[16] = new Note(58);
		melodyNotes[16].setVal(NoteValue.Eighth);
		melodyNotes[17] = new Note(54);
		melodyNotes[17].setVal(NoteValue.Eighth);

		melodyNotes[18] = new Note(53);
		melodyNotes[18].setVal(NoteValue.Eighth);
		melodyNotes[19] = new Note(56);
		melodyNotes[19].setVal(NoteValue.Eighth);
		melodyNotes[20] = new Note(56);
		melodyNotes[20].setVal(NoteValue.Eighth);
		melodyNotes[21] = new Note(53);
		melodyNotes[21].setVal(NoteValue.Eighth);
		
		melodyNotes[22] = new Note(51);
		melodyNotes[22].setVal(NoteValue.Eighth);
		melodyNotes[23] = new Note(54);
		melodyNotes[23].setVal(NoteValue.Eighth);
		melodyNotes[24] = new Note(53);
		melodyNotes[24].setVal(NoteValue.Eighth);
		melodyNotes[25] = new Note(51);
		melodyNotes[25].setVal(NoteValue.Eighth);
		
		melodyNotes[26] = new Note(49);
		melodyNotes[27] = new Note(49);
		
		melodyNotes[28] = new Note(54);
		melodyNotes[28].setVal(NoteValue.Eighth);
		melodyNotes[29] = new Note(58);
		melodyNotes[29].setVal(NoteValue.Eighth);
		melodyNotes[30] = new Note(58);
		melodyNotes[30].setVal(NoteValue.Eighth);
		melodyNotes[31] = new Note(54);
		melodyNotes[31].setVal(NoteValue.Eighth);

		melodyNotes[32] = new Note(53);
		melodyNotes[32].setVal(NoteValue.Eighth);
		melodyNotes[33] = new Note(56);
		melodyNotes[33].setVal(NoteValue.Eighth);
		melodyNotes[34] = new Note(56);
		melodyNotes[34].setVal(NoteValue.Eighth);
		melodyNotes[35] = new Note(53);
		melodyNotes[35].setVal(NoteValue.Eighth);
		
		melodyNotes[36] = new Note(51);
		melodyNotes[36].setVal(NoteValue.Eighth);
		melodyNotes[37] = new Note(54);
		melodyNotes[37].setVal(NoteValue.Eighth);
		melodyNotes[38] = new Note(53);
		melodyNotes[38].setVal(NoteValue.Eighth);
		melodyNotes[39] = new Note(51); 
		melodyNotes[39].setVal(NoteValue.Eighth);
		
		melodyNotes[40] = new Note(49);
		melodyNotes[41] = new Note(49);
		
		solve(s,melodyNotes);//lacks chords to find a solution
		s.addToAvailableChords(new S6Picker());//add additional chord type
		solve(s,melodyNotes);//still lacks chords to find a solution
		
	}
	private static void trySolvingAMelody(){
		//set up the rules
		RuleSet rs = RuleSet.getRuleSet();
		rs.addRule(ParallelFifths.getInstance());
		rs.addRule(ParallelOctaves.getInstance());
		rs.addRule(AllVoicesUp.getInstance());
		rs.addRule(AllVoicesDown.getInstance());
		//Create a solver
		Solver s = new Solver();//uses three basic chords: T5 S5 and D5
		//Create a melody:
		Note[] melodyNotes = new Note[14];
		melodyNotes[0] = new Note(56);
		melodyNotes[0].setVal(NoteValue.Eighth);
		melodyNotes[1] = new Note(56);
		melodyNotes[1].setVal(NoteValue.Eighth);
		melodyNotes[2] = new Note(53);
		melodyNotes[2].setVal(NoteValue.Eighth);
		melodyNotes[3] = new Note(49);
		melodyNotes[3].setVal(NoteValue.Eighth);
		
		melodyNotes[4] = new Note(56);
		melodyNotes[4].setVal(NoteValue.Eighth);
		melodyNotes[5] = new Note(56);
		melodyNotes[5].setVal(NoteValue.Eighth);
		melodyNotes[6] = new Note(53);
		melodyNotes[6].setVal(NoteValue.Eighth);
		melodyNotes[7] = new Note(49);
		melodyNotes[7].setVal(NoteValue.Eighth);
		
		melodyNotes[8] = new Note(54);
		melodyNotes[8].setVal(NoteValue.Eighth);
		melodyNotes[9] = new Note(58);
		melodyNotes[9].setVal(NoteValue.Eighth);
		melodyNotes[10] = new Note(61);
		melodyNotes[10].setVal(NoteValue.Eighth);
		melodyNotes[11] = new Note(58);
		melodyNotes[11].setVal(NoteValue.Eighth);
		
		melodyNotes[12] = new Note(56);
		melodyNotes[13] = new Note(56);
		for(Note n: melodyNotes){
			s.addNote(n);//add melody to solver
		}
		solve(s,melodyNotes);//lacks chords to find a solution
		s.addToAvailableChords(new S6Picker());//add additional chord type
		solve(s,melodyNotes);//solution found
		rs.removeRule(ParallelFifths.getInstance());
		rs.removeRule(ParallelOctaves.getInstance());
		rs.removeRule(AllVoicesUp.getInstance());
		rs.removeRule(AllVoicesDown.getInstance());
		solve(s,melodyNotes);//solution (no rules) found
		
	}
	private static void solve(Solver s,Note[] melodyNotes){
		System.out.println("Trying to solve the given melody...");
		ArrayList<Chord> result = s.solve();//solve
		
		System.out.println("Harmonization results:");
		for(int i = 0; i < result.size();i++){//Lacks chords to find a solution
			System.out.println(melodyNotes[i] + " -> " + result.get(i));
		}
	}

}
