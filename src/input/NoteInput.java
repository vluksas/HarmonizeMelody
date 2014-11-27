package input;

import harmonizator.Note;
import harmonizator.ScaleDegree;
import harmonizator.Chords.Chord;
import harmonizator.Solver.Solver;
import harmonizator.Solver.ChordTypePicker.ChordTypePicker;
import harmonizator.Solver.ChordTypePicker.ChordTypePickerGeneral;
import harmonizator.Solver.ChordTypePicker.S6Picker;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;

public class NoteInput {

	private JFrame frmNoteinput;
	private JSpinner octaveChooser;
	private Solver harmonizator;
	private int inputCounter;
	
	//Solution section elements:
	private JPanel soprano_line;
	private JPanel alto_line;
	private JPanel tenor_line;
	private JPanel bass_line;
	private ArrayList<NoteButton> melodyNotes;
	private ArrayList<NoteButton> v2Notes;
	private ArrayList<NoteButton> v3Notes;
	private ArrayList<NoteButton> bassNotes;

	public JSpinner getOctaveChooser() {
		return octaveChooser;
	}
	public NoteInput() {
		inputCounter = 0;
		harmonizator = new Solver(setAvailableChords());
		melodyNotes = new ArrayList<NoteButton>();
		v2Notes = new ArrayList<NoteButton>();
		v3Notes = new ArrayList<NoteButton>();
		bassNotes = new ArrayList<NoteButton>();
		initialize();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoteInput window = new NoteInput();
					window.frmNoteinput.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private ChordTypePicker setAvailableChords(){
		ChordTypePicker ctp = ChordTypePickerGeneral.buildBaseChordTree();
		ctp.add(new S6Picker());
		return ctp;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNoteinput = new JFrame();
		frmNoteinput.setTitle("NoteInput");
		frmNoteinput.setBounds(100, 100, 786, 404);
		frmNoteinput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNoteinput.getContentPane().setLayout(new GridLayout(0, 1, 1, 1));
		
		JPanel result_panel = new JPanel();
		result_panel.setToolTipText("asd");
		frmNoteinput.getContentPane().add(result_panel);
		result_panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		soprano_line = new JPanel();
		result_panel.add(soprano_line);
		soprano_line.setLayout(null);
		
		JLabel lblSoprano = new JLabel("Soprano:");
		lblSoprano.setBounds(10, 10, 60, 14);
		soprano_line.add(lblSoprano);
		
		alto_line = new JPanel();
		result_panel.add(alto_line);
		alto_line.setLayout(null);
		
		JLabel lblAlto = new JLabel("Alto:");
		lblAlto.setBounds(10, 10, 60, 14);
		alto_line.add(lblAlto);
		
		tenor_line = new JPanel();
		result_panel.add(tenor_line);
		tenor_line.setLayout(null);
		
		JLabel lblTenor = new JLabel("Tenor:");
		lblTenor.setBounds(10, 10, 60, 14);
		tenor_line.add(lblTenor);
		
		bass_line = new JPanel();
		result_panel.add(bass_line);
		bass_line.setLayout(null);
		
		JLabel lblBass = new JLabel("Bass:");
		lblBass.setBounds(10, 10, 60, 14);
		bass_line.add(lblBass);
		
		JPanel input_container = new JPanel();
		frmNoteinput.getContentPane().add(input_container);
		GridBagLayout gbl_input_container = new GridBagLayout();
		gbl_input_container.columnWidths = new int[]{770, 0};
		gbl_input_container.rowHeights = new int[] {150, 32, 0};
		gbl_input_container.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_input_container.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		input_container.setLayout(gbl_input_container);
		
		JPanel keyboard_panel = new JPanel();
		keyboard_panel.setBackground(Color.BLACK);
		GridBagConstraints gbc_keyboard_panel = new GridBagConstraints();
		gbc_keyboard_panel.fill = GridBagConstraints.BOTH;
		gbc_keyboard_panel.insets = new Insets(0, 0, 5, 0);
		gbc_keyboard_panel.gridx = 0;
		gbc_keyboard_panel.gridy = 0;
		input_container.add(keyboard_panel, gbc_keyboard_panel);
		GridBagLayout gbl_keyboard_panel = new GridBagLayout();
		gbl_keyboard_panel.columnWidths = new int[] {79, 43, 79, 43, 79, 79, 43, 79, 43, 79, 43, 79, 0};
		gbl_keyboard_panel.rowHeights = new int[]{144, 0};
		gbl_keyboard_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_keyboard_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		keyboard_panel.setLayout(gbl_keyboard_panel);
		
		JButton btnC = new JButton("");
		addButtonToPanel(keyboard_panel, btnC, 0, Color.WHITE);
		
		JButton btnCSharp = new JButton("");
		addButtonToPanel(keyboard_panel, btnCSharp, 1, Color.BLACK);
		
		JButton btnD = new JButton("");
		addButtonToPanel(keyboard_panel, btnD, 2, Color.WHITE);
		
		JButton btnEFlat = new JButton("");
		addButtonToPanel(keyboard_panel, btnEFlat, 3, Color.BLACK);
		
		JButton btnE = new JButton("");
		addButtonToPanel(keyboard_panel, btnE, 4, Color.WHITE);
		
		JButton btnF = new JButton("");
		addButtonToPanel(keyboard_panel, btnF, 5, Color.WHITE);
		
		JButton btnFSharp = new JButton("");
		addButtonToPanel(keyboard_panel, btnFSharp, 6, Color.BLACK);
		
		JButton btnG = new JButton("");
		addButtonToPanel(keyboard_panel, btnG, 7, Color.WHITE);
		
		JButton btnGSharp = new JButton("");
		addButtonToPanel(keyboard_panel, btnGSharp, 8, Color.BLACK);
		
		JButton btnA = new JButton("");
		addButtonToPanel(keyboard_panel, btnA, 9, Color.WHITE);
		
		JButton btnB = new JButton("");
		addButtonToPanel(keyboard_panel, btnB, 10, Color.BLACK);
		
		JButton btnH = new JButton("");
		addButtonToPanel(keyboard_panel, btnH, 11, Color.WHITE);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		input_container.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Octave:");
		lblNewLabel.setBounds(10, 8, 150, 14);
		
		SpinnerNumberModel availableOctaves = new SpinnerNumberModel(2.0, Note.MIN_OCTAVE,Note.MAX_OCTAVE, 1.0);  
		octaveChooser = new JSpinner(new SpinnerNumberModel(3, 0, 8, 1));
		octaveChooser.setBounds(170, 5, 205, 20);
		panel_4.setLayout(null);
		panel_4.add(lblNewLabel);
		panel_4.add(octaveChooser);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JButton btnSolve = new JButton("Solve");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoteInput.this.harmonize();
			}
		});
		panel_5.add(btnSolve);
	}

	private void addButtonToPanel(JPanel panel_1, JButton btn, int gridx, Color bgColor) {
		btn.setBackground(bgColor);
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.insets = new Insets(0, 0, 0, 5);
		gbc_btn.gridx = gridx;
		gbc_btn.gridy = 0;
		btn.addActionListener(new NoteListener(gridx+1));
		panel_1.add(btn, gbc_btn);
	}

	public void addNewNote(int note_id){
		Note n = new Note(note_id);
		NoteButton nb = new NoteButton(n,inputCounter++);
		soprano_line.add(nb);
		this.frmNoteinput.repaint();
		harmonizator.addNote(n);
		melodyNotes.add(nb);
	}
	public void harmonize(){
		harmonizator.solve();
		int i = 0;
		for(Chord res:harmonizator.getHarmony()){
			if(i <= inputCounter){
				addHarmonyNoteButtons(i, res);
			}else{
				updateHarmonyNoteButtons(i, res);
			}
			i++;
			this.frmNoteinput.repaint();
		}
	}
	private void addHarmonyNoteButtons(int i, Chord res) {
		if(res == null){
			NoteButton nb = new NoteButton(null,i,"?");
			v2Notes.add(nb);
			alto_line.add(nb);
			nb = new NoteButton(null,i,"?");
			v3Notes.add(nb);
			tenor_line.add(nb);
			nb = new NoteButton(null,i,"?");
			bassNotes.add(nb);
			bass_line.add(nb);
		}else{
			NoteButton nb = new NoteButton(res.getNote(1),i);
			v2Notes.add(nb);
			alto_line.add(nb);
			nb = new NoteButton(res.getNote(2),i);
			v3Notes.add(nb);
			tenor_line.add(nb);
			nb = new NoteButton(res.getNote(3),i);
			bassNotes.add(nb);
			bass_line.add(nb);
		}
	}
	private void updateHarmonyNoteButtons(int i, Chord res) {
		if(res == null){
			v2Notes.get(i).changeNote(null, "?");
			v3Notes.get(i).changeNote(null, "?");
			bassNotes.get(i).changeNote(null, "?");
		}else{
			v2Notes.get(i).changeNote(res.getNote(1));
			v3Notes.get(i).changeNote(res.getNote(2));
			bassNotes.get(i).changeNote(res.getNote(3));
		}
	}
	class NoteListener implements ActionListener{
		int note_id;
		public NoteListener(int note_id){
			this.note_id = note_id;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			NoteInput.this.addNewNote(note_id+(((Integer)NoteInput.this.getOctaveChooser().getValue())*12));//awful type casting...
		}
		
	}
	class NoteButton extends JButton{
		public static final int NOTE_BUTTON_WIDTH = 60;
		public static final int NOTE_BUTTON_HEIGHT = 40;
		public static final int BASE_X = 100;
		public static final int BASE_Y = 5;
		Note markedNote;
		int index;
		public NoteButton(Note n, int number){
			markedNote = n;
			index = number;
			this.setVisible(true);
			this.setText(markedNote.toString());
			this.setBounds(BASE_X + number*NOTE_BUTTON_WIDTH, BASE_Y, NOTE_BUTTON_WIDTH, NOTE_BUTTON_HEIGHT);
		}
		public NoteButton(Note n, int number, String text){
			markedNote = n;
			index = number;
			this.setVisible(true);
			this.setText(text);
			this.setBounds(BASE_X + number*NOTE_BUTTON_WIDTH, BASE_Y, NOTE_BUTTON_WIDTH, NOTE_BUTTON_HEIGHT);
		}
		public NoteButton(Note n, int number, boolean needsRemovalListener){
			markedNote = n;
			index = number;
			this.setVisible(true);
			this.setText(markedNote.toString());
			this.setBounds(BASE_X + number*NOTE_BUTTON_WIDTH, BASE_Y, NOTE_BUTTON_WIDTH, NOTE_BUTTON_HEIGHT);
		}
		public void changeNote(Note substitute){
			markedNote = substitute;
			this.setText(markedNote.toString());
		}
		public void changeNote(Note substitute,String subName){
			markedNote = substitute;
			this.setText(subName);
		}
	}
}
