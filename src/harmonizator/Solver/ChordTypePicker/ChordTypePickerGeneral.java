package harmonizator.Solver.ChordTypePicker;

import java.util.ArrayList;

import harmonizator.ScaleDegree;
import harmonizator.Chords.ChordSelector;
import harmonizator.Chords.ChordType;
import harmonizator.Solver.ChordSuggestion;
import harmonizator.Solver.ChordVariation;

public class ChordTypePickerGeneral implements ChordTypePicker{

	public enum SplitElement {ChordType,ChordVariation,ScaleDegree}
	protected SplitElement se;
	protected ArrayList<ChordTypePicker> childNodes;
	protected ChordSuggestion cs;
	public ChordTypePickerGeneral(){
		se = SplitElement.ChordType;
		cs = new ChordSuggestion();
	}
	public ChordTypePickerGeneral(SplitElement type, ChordSuggestion cs){
		se = type;
		childNodes = null;
		this.cs = cs;
	}
	protected void performSelection(ChordSelector cs){//Subclasses should override this to do the class picking
		return;
	}
	@Override
	public void pickType(ChordSelector cs, ChordSuggestion csug) {
		// TODO Auto-generated method stub
		if(childNodes == null){
			performSelection(cs);
			return;
		}
		switch(se){
		case ChordType:
			for(ChordTypePicker cpc:childNodes){
				if(cpc.getChordSuggestion().getChordType() == csug.getChordType()){
					cpc.pickType(cs, csug);
					return;
				}
			}
			return;
		case ChordVariation:
			for(ChordTypePicker cpc:childNodes){
				if(cpc.getChordSuggestion().getChordVariation() == csug.getChordVariation()){
					cpc.pickType(cs, csug);
					return;
				}
			}
			return;
		case ScaleDegree:
			for(ChordTypePicker cpc:childNodes){
				if(cpc.getChordSuggestion().getScDeg() == csug.getScDeg()){
					cpc.pickType(cs, csug);
					return;
				}
			}
			return;
		default:
			return;
		}
	}
	@Override
	public void add(ChordTypePicker cp) {
		// TODO Auto-generated method stub
		if(childNodes == null){
			childNodes = new ArrayList<ChordTypePicker>();
		}
		switch(se){
		case ChordType:
			for(ChordTypePicker cpc:childNodes){
				if(cpc.getChordSuggestion().getChordType() == cp.getChordSuggestion().getChordType()){
					cpc.add(cp);
					return;
				}
			}
			childNodes.add(cp);
			return;
		case ChordVariation:
			for(ChordTypePicker cpc:childNodes){
				if(cpc.getChordSuggestion().getChordVariation() == cp.getChordSuggestion().getChordVariation()){
					cpc.add(cp);
					return;
				}
			}
			childNodes.add(cp);
			return;
		case ScaleDegree:
			for(ChordTypePicker cpc:childNodes){
				if(cpc.getChordSuggestion().getScDeg() == cp.getChordSuggestion().getScDeg()){
					cpc.add(cp);
					return;
				}
			}
			childNodes.add(cp);
			return;
		default:
			childNodes.add(cp);
			return;
		}
		
	}
	public ChordSuggestion getChordSuggestion() {
		return cs;
	}
	public void setCs(ChordSuggestion cs) {
		this.cs = cs;
	}
	@Override
	public ChordTypePicker getChild(int numOfChild) {
		if(childNodes != null){
			if(childNodes.size() >= numOfChild){
				return childNodes.get(numOfChild);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	
	/*
	 * Builds basic tree structure to contain ChordTypePicker objects
	 */
	public static ChordTypePicker buildBaseTree(){
		ChordSuggestion dummy = new ChordSuggestion();
		ChordTypePicker root = new ChordTypePickerGeneral(SplitElement.ChordType,dummy);
		//Create 1st tier of children:
		ChordTypePicker l1_1 = createNode(ChordVariation.P5, SplitElement.ChordVariation);
		ChordTypePicker l1_2 = createNode(ChordVariation.P7, SplitElement.ChordVariation);
		root.add(l1_1);
		root.add(l1_2);
		//Create 2nd tier of children
		ChordTypePicker[] l2 = new ChordTypePicker[7];
		l2[0] = createNode(ChordVariation.P5, SplitElement.ScaleDegree);
		l2[1] = createNode(ChordVariation.P6, SplitElement.ScaleDegree);
		l2[2] = createNode(ChordVariation.P64, SplitElement.ScaleDegree);
		l2[3] = createNode(ChordVariation.P7, SplitElement.ScaleDegree);
		l2[4] = createNode(ChordVariation.P56, SplitElement.ScaleDegree);
		l2[5] = createNode(ChordVariation.P34, SplitElement.ScaleDegree);
		l2[6] = createNode(ChordVariation.P2, SplitElement.ScaleDegree);
		for(ChordTypePicker cp:l2){
			root.add(cp);
		}
		//Create 3rd tier of children
		for(ChordVariation cv : ChordVariation.values()){
			ChordTypePicker[] l3 = new ChordTypePicker[7];
			l3[0] = createNode(cv,ScaleDegree.Tonic, SplitElement.ScaleDegree);
			l3[1] = createNode(cv,ScaleDegree.Supertonic, SplitElement.ScaleDegree);
			l3[2] = createNode(cv,ScaleDegree.Mediant, SplitElement.ScaleDegree);
			l3[3] = createNode(cv,ScaleDegree.Subdominant, SplitElement.ScaleDegree);
			l3[4] = createNode(cv,ScaleDegree.Dominant, SplitElement.ScaleDegree);
			l3[5] = createNode(cv,ScaleDegree.Submediant, SplitElement.ScaleDegree);
			l3[6] = createNode(cv,ScaleDegree.Subtonic, SplitElement.ScaleDegree);
			for(ChordTypePicker cp:l3){
				root.add(cp);
			}
		}
		return root;
	}
	public static ChordTypePicker buildBaseChordTree(){
		ChordTypePicker root = ChordTypePickerGeneral.buildBaseTree();
		ChordTypePickerGeneral.setBaseChords(root);
		return root;
	}
	protected static ChordTypePicker createNode(ChordVariation cv,SplitElement se){
		ChordSuggestion data = new ChordSuggestion();
		data.setChordVariation(cv);
		ChordTypePicker element = new ChordTypePickerGeneral(se,data);
		return element;
	}
	protected static ChordTypePicker createNode(ChordVariation cv, ScaleDegree scDeg, SplitElement se){
		ChordSuggestion data = new ChordSuggestion();
		data.setChordVariation(cv);
		data.setScDeg(scDeg);
		ChordTypePicker element = new ChordTypePickerGeneral(se,data);
		return element;
	}
	protected static ChordTypePicker createNode(ScaleDegree scDeg, SplitElement se){
		ChordSuggestion data = new ChordSuggestion();
		data.setScDeg(scDeg);
		ChordTypePicker element = new ChordTypePickerGeneral(se,data);
		return element;
	}
	public void addToAvailableChords(ChordTypePicker ctp){
		this.add(ctp);
	}
	public void addToAvailableChords(Iterable<ChordTypePicker> ctps){
		for(ChordTypePicker ctp:ctps){
			this.add(ctp);
		}
	}
	private static void setBaseChords(ChordTypePicker root){
		root.add(new T5Picker());
		root.add(new S5Picker());
		root.add(new D5Picker());
	}
}
