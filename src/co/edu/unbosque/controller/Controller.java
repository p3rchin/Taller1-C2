package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.filechooser.FileView;

import co.edu.unbosque.view.FileWindowView;
import co.edu.unbosque.view.PrincipalView;

public class Controller implements ActionListener {

	private PrincipalView principalView;
	private FileWindowView fileView;

	public Controller() throws Exception {

		principalView = new PrincipalView();
		fileView = new FileWindowView();

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
			String file = fileView.openFileToSearch();
			fileView.getTextAreaShow().setText(file);
			
			
		}else if(command.equals("SEARCHWORD")) {
			
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
