package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import co.edu.unbosque.model.AlgorithmBM;
import co.edu.unbosque.model.AlgorithmKMP;
import co.edu.unbosque.view.FileWindowView;
import co.edu.unbosque.view.PrincipalView;

public class Controller implements ActionListener {

	private PrincipalView principalView;
	private FileWindowView fileView;
	private AlgorithmBM algorithmBM;
	private AlgorithmKMP algorithmKMP;
	private String file;
	private ArrayList<Integer> numeros;

	/**
	 * 
	 * @throws Exception
	 */
	public Controller() throws Exception {

		principalView = new PrincipalView();
		fileView = new FileWindowView();
		algorithmBM = new AlgorithmBM();
		algorithmKMP = new AlgorithmKMP();
		numeros = new ArrayList<>();

		assignListeners();
	}

	public void assignListeners() {

		principalView.getMinimize().addActionListener(this);
		principalView.getClose().addActionListener(this);
		principalView.getButton1().addActionListener(this);
		fileView.getMinimize().addActionListener(this);
		fileView.getClose().addActionListener(this);
		fileView.getReturnButton().addActionListener(this);
		fileView.getButton1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("WINDOWMINIMIZE")) {
			principalView.setExtendedState(JFrame.ICONIFIED);

		} else if (command.equals("WINDOWCLOSE")) {
			System.exit(0);
		}

		if (command.equals("INFILE")) {
			principalView.setVisible(false);
			fileView.setVisible(true);
			file = fileView.openFileToSearch();
			fileView.getTextAreaShow().setText(file);

		} else if (command.equals("SEARCHWORD")) {

			if (!"".equals(fileView.getTextSearch().getText())) {

				String word = fileView.getTextSearch().getText();
				numeros = algorithmBM.search(file.toUpperCase(), word.toUpperCase());
				try {
					fileView.highlightText(word, numeros, fileView.getTextAreaShow());
					fileView.getEstadisticText().setText("La palabra se repite: " + numeros.get(numeros.size() - 1));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "\n You must write a word ", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (command.equals("WINDOWRETURN")) {
			fileView.setVisible(false);
			principalView.setVisible(true);

		} else if (command.equals("WINDOWMINIMIZE1")) {
			fileView.setExtendedState(JFrame.ICONIFIED);
		} else if (command.equals("WINDOWCLOSE1")) {
			System.exit(0);
		}
	}
}
