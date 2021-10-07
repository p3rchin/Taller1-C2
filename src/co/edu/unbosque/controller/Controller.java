/**
 * Package containing the class
 */
package co.edu.unbosque.controller;

import java.awt.Color;
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


/**
 * 
 * @author Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago
 *         Acevedo.
 *
 */

public class Controller implements ActionListener {

	
	/**
	 * principalView is the instance of PrincipalView.
	 */
	
	private PrincipalView principalView;
	
	/**
	 * fileView is the instance of FileWindowView.
	 */
	
	private FileWindowView fileView;
	
	/**
	 * algorithmBM is the instance of AlgorithmBM.
	 */
	
	private AlgorithmBM algorithmBM;
	
	/**
	 * algorithmKMP is the instance of AlgorithmKMP.
	 */
	private AlgorithmKMP algorithmKMP;
	
	/**
	 * file is the String type.
	 */
	private String file;
	
	/**
	 * colorBM is the Color type.
	 */
	private Color colorBM;
	
	/**
	 * colorKMP is the Color type.
	 */
	private Color colorKMP;
	
	/**
	 * numeros is the ArrayList type.
	 */
	private ArrayList<Integer> numeros;
	
	
	
	/**
	 * This constructor define the instances.
	 * <b>pre</b>Must exist declarations of the instances.<br>
	 * <b>post</b>The instances of a class.</br>
	 * @throws Exception is an event when a error occurred.
	 */

	public Controller() throws Exception {

		principalView = new PrincipalView();
		fileView = new FileWindowView();
		algorithmBM = new AlgorithmBM();
		algorithmKMP = new AlgorithmKMP();
		numeros = new ArrayList<>();
		colorBM = new Color(240, 128, 128);
		colorKMP = new Color(152, 251, 152);

		assignListeners();
	}

	/**
	 * This method assign the listeners.
	 * <b>pre</b>The components must be exist.<br>
	 * <b>post</b>A command must be developed.<br>
	 */
	
	public void assignListeners() {

		principalView.getMinimize().addActionListener(this);
		principalView.getClose().addActionListener(this);
		principalView.getButton1().addActionListener(this);
		fileView.getMinimize().addActionListener(this);
		fileView.getClose().addActionListener(this);
		fileView.getReturnButton().addActionListener(this);
		fileView.getButton1().addActionListener(this);
		fileView.getButton4().addActionListener(this);

	}

	
	/**
	 * This method react to listeners.
	 * <b>pre</b>The listeners must be exist.<br>
	 * <b>post</b>An event must be occurred.<br>
	 */
	
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

				if (fileView.getOption().getSelectedItem().equals("Select the algorithm")) {
					JOptionPane.showMessageDialog(null, "\n Choose an algorithm ", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else if (fileView.getOption().getSelectedItem().equals("BM")) {
					JOptionPane.showMessageDialog(null, "\n The user choose the algorithm BM ", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					String word = fileView.getTextSearch().getText();
					numeros = algorithmBM.search(file.toLowerCase(), word.toLowerCase());
					try {
						fileView.getTextAreaShow().setText(file);
						fileView.highlightText(word, numeros, fileView.getTextAreaShow(), colorBM);
						fileView.getEstadisticText()
								.setText("La palabra se repite: " + numeros.get(numeros.size() - 1) + " veces.");
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "\n The user choose the algorithm KMP ", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					String word = fileView.getTextSearch().getText();
					numeros = algorithmKMP.KMPSearch(file.toLowerCase(), word.toLowerCase());
					try {
						fileView.getTextAreaShow().setText(file);
						fileView.highlightText(word, numeros, fileView.getTextAreaShow(), colorKMP);
						fileView.getEstadisticText()
								.setText("La palabra se repite: " + numeros.get(numeros.size() - 1) + " veces.");
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "\n You must write a word ", "Error", JOptionPane.WARNING_MESSAGE);
			}

		} else if (command.equals("CLEANTEXT")) {
			
			fileView.getTextAreaShow().setText(file);
			fileView.getTextSearch().setText("");
			fileView.getOption().setSelectedIndex(0);
			fileView.getEstadisticText().setText("");

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
