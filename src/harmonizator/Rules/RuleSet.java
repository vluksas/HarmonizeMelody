package harmonizator.Rules;

import java.util.ArrayList;

import harmonizator.Chords.Chord;

public class RuleSet {
	private static RuleSet instance = null;
	private ArrayList<Rule> rules;
	private RuleSet(){
		rules = new ArrayList<Rule>();
	}
	
	public static RuleSet getRuleSet(){
		if(instance == null){
			instance = new RuleSet();
			return instance;
		}else{
			return instance;
		}
	}
	public void addRule(Rule r){
		rules.add(r); 
	}
	public void removeRule(Rule r){
		rules.remove(r);
	}
	public void clearAll(){
		rules.clear();
	}
	public int correctJoining(Chord a,Chord b){
		// -1 - incorrect joining; 0 - correct joining;
		//> 0 - allowed joining;
		if(a == null || b == null){
			return 0;
		}
		int cJ = 0;
		for(Rule r:rules){
			if(!r.correctJoining(a, b)){
				if(r.isCompulsory()){
					return -1;
				}else{
					cJ += r.getImportanceLevel();
				}
			}
		}
		return cJ;
	}
}
