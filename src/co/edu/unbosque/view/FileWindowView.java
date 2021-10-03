package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileWindowView extends JFrame {

	private ImageIcon background1, sourceBackground, imageButton1, sourceButton1, imageButton2, sourceButton2,
			imageButton3, sourceButton3, imageButton4, sourceButton4;
	private JLabel imageBackground;
	private TypeButton button1, button2, button3;
	private JButton returnButton, minimize, close;
	private JLabel title1;
	private JTextArea textAreaShow;
	private JScrollPane scrollPane;
	private JFileChooser fileChooser;
	String texto;

	public FileWindowView() {

		setTitle("Words searcher");
		setSize(800, 500);
		setUndecorated(true);
		initialize();
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(false);

	}

	public void initialize() {

		fileChooser = new JFileChooser(); 

		title1 = new JLabel("Enter the word to search");
		title1.setBounds(260, 2, 400, 50);
		title1.setFont(new Font("Arial", Font.CENTER_BASELINE, 22));
		add(title1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 765, 350);
		add(scrollPane);

		textAreaShow = new JTextArea();
		textAreaShow.setEditable(false);
		textAreaShow.setBackground(Color.white);
		textAreaShow.setFont(new Font("Verdama", Font.ROMAN_BASELINE, 12));
		textAreaShow.setLineWrap(true);
		scrollPane.setViewportView(textAreaShow);

		imageButton1 = new ImageIcon("images/minimize.png");
		sourceButton1 = new ImageIcon(imageButton1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		minimize = new JButton();
		minimize.setBounds(750, 5, 20, 20);
		minimize.setBorderPainted(false);
		minimize.setContentAreaFilled(false);
		minimize.setFocusPainted(false);
		minimize.setIcon(sourceButton1);
		minimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimize.setActionCommand("WINDOWMINIMIZE1");
		add(minimize);

		imageButton2 = new ImageIcon("images/close.png");
		sourceButton2 = new ImageIcon(imageButton2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		close = new JButton();
		close.setBounds(775, 5, 20, 20);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		close.setIcon(sourceButton2);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.setActionCommand("WINDOWCLOSE1");
		add(close);
		
		imageButton3 = new ImageIcon("images/previous.png");
		sourceButton3 = new ImageIcon(imageButton3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		returnButton = new JButton();
		returnButton.setBounds(5, 5, 20, 20);
		returnButton.setBorderPainted(false);
		returnButton.setContentAreaFilled(false);
		returnButton.setFocusPainted(false);
		returnButton.setIcon(sourceButton3);
		returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnButton.setActionCommand("WINDOWRETURN");
		add(returnButton);

		background1 = new ImageIcon(getClass().getResource("/images/background1.png"));
		sourceBackground = new ImageIcon(background1.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH));
		imageBackground = new JLabel(sourceBackground);
		imageBackground.setSize(800, 600);
		add(imageBackground);
	}

	public String openFileToSearch() {

		String aux = "";
		texto = "";

		try {
			/* llamamos el metodo que permite cargar la ventana */
			fileChooser.showOpenDialog(this);
			/* abrimos el archivo seleccionado */
			File abre = fileChooser.getSelectedFile();

			/*
			 * recorremos el archivo, lo leemos para plasmarlo en el area de texto
			 */
			if (abre != null) {
				FileReader archivos = new FileReader(abre);
				BufferedReader lee = new BufferedReader(archivos);
				while ((aux = lee.readLine()) != null) {
					texto += aux + "\n";
				}

				lee.close();
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo", "ADVERTENCIA!!!",
					JOptionPane.WARNING_MESSAGE);
		}
		return texto;
	}

	/**
	 * @return the background1
	 */
	public ImageIcon getBackground1() {
		return background1;
	}

	/**
	 * @param background1 the background1 to set
	 */
	public void setBackground1(ImageIcon background1) {
		this.background1 = background1;
	}

	/**
	 * @return the sourceBackground
	 */
	public ImageIcon getSourceBackground() {
		return sourceBackground;
	}

	/**
	 * @param sourceBackground the sourceBackground to set
	 */
	public void setSourceBackground(ImageIcon sourceBackground) {
		this.sourceBackground = sourceBackground;
	}

	/**
	 * @return the imageButton1
	 */
	public ImageIcon getImageButton1() {
		return imageButton1;
	}

	/**
	 * @param imageButton1 the imageButton1 to set
	 */
	public void setImageButton1(ImageIcon imageButton1) {
		this.imageButton1 = imageButton1;
	}

	/**
	 * @return the sourceButton1
	 */
	public ImageIcon getSourceButton1() {
		return sourceButton1;
	}

	/**
	 * @param sourceButton1 the sourceButton1 to set
	 */
	public void setSourceButton1(ImageIcon sourceButton1) {
		this.sourceButton1 = sourceButton1;
	}

	/**
	 * @return the imageButton2
	 */
	public ImageIcon getImageButton2() {
		return imageButton2;
	}

	/**
	 * @param imageButton2 the imageButton2 to set
	 */
	public void setImageButton2(ImageIcon imageButton2) {
		this.imageButton2 = imageButton2;
	}

	/**
	 * @return the sourceButton2
	 */
	public ImageIcon getSourceButton2() {
		return sourceButton2;
	}

	/**
	 * @param sourceButton2 the sourceButton2 to set
	 */
	public void setSourceButton2(ImageIcon sourceButton2) {
		this.sourceButton2 = sourceButton2;
	}

	/**
	 * @return the imageButton3
	 */
	public ImageIcon getImageButton3() {
		return imageButton3;
	}

	/**
	 * @param imageButton3 the imageButton3 to set
	 */
	public void setImageButton3(ImageIcon imageButton3) {
		this.imageButton3 = imageButton3;
	}

	/**
	 * @return the sourceButton3
	 */
	public ImageIcon getSourceButton3() {
		return sourceButton3;
	}

	/**
	 * @param sourceButton3 the sourceButton3 to set
	 */
	public void setSourceButton3(ImageIcon sourceButton3) {
		this.sourceButton3 = sourceButton3;
	}

	/**
	 * @return the imageButton4
	 */
	public ImageIcon getImageButton4() {
		return imageButton4;
	}

	/**
	 * @param imageButton4 the imageButton4 to set
	 */
	public void setImageButton4(ImageIcon imageButton4) {
		this.imageButton4 = imageButton4;
	}

	/**
	 * @return the sourceButton4
	 */
	public ImageIcon getSourceButton4() {
		return sourceButton4;
	}

	/**
	 * @param sourceButton4 the sourceButton4 to set
	 */
	public void setSourceButton4(ImageIcon sourceButton4) {
		this.sourceButton4 = sourceButton4;
	}

	/**
	 * @return the imageBackground
	 */
	public JLabel getImageBackground() {
		return imageBackground;
	}

	/**
	 * @param imageBackground the imageBackground to set
	 */
	public void setImageBackground(JLabel imageBackground) {
		this.imageBackground = imageBackground;
	}

	/**
	 * @return the button1
	 */
	public TypeButton getButton1() {
		return button1;
	}

	/**
	 * @param button1 the button1 to set
	 */
	public void setButton1(TypeButton button1) {
		this.button1 = button1;
	}

	/**
	 * @return the button2
	 */
	public TypeButton getButton2() {
		return button2;
	}

	/**
	 * @param button2 the button2 to set
	 */
	public void setButton2(TypeButton button2) {
		this.button2 = button2;
	}

	/**
	 * @return the button3
	 */
	public TypeButton getButton3() {
		return button3;
	}

	/**
	 * @param button3 the button3 to set
	 */
	public void setButton3(TypeButton button3) {
		this.button3 = button3;
	}

	/**
	 * @return the returnButton
	 */
	public JButton getReturnButton() {
		return returnButton;
	}

	/**
	 * @param returnButton the returnButton to set
	 */
	public void setReturnButton(JButton returnButton) {
		this.returnButton = returnButton;
	}

	/**
	 * @return the minimize
	 */
	public JButton getMinimize() {
		return minimize;
	}

	/**
	 * @param minimize the minimize to set
	 */
	public void setMinimize(JButton minimize) {
		this.minimize = minimize;
	}

	/**
	 * @return the close
	 */
	public JButton getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(JButton close) {
		this.close = close;
	}

	/**
	 * @return the title1
	 */
	public JLabel getTitle1() {
		return title1;
	}

	/**
	 * @param title1 the title1 to set
	 */
	public void setTitle1(JLabel title1) {
		this.title1 = title1;
	}

	/**
	 * @return the textAreaShow
	 */
	public JTextArea getTextAreaShow() {
		return textAreaShow;
	}

	/**
	 * @param textAreaShow the textAreaShow to set
	 */
	public void setTextAreaShow(JTextArea textAreaShow) {
		this.textAreaShow = textAreaShow;
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	/**
	 * @return the fileChooser
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * @param fileChooser the fileChooser to set
	 */
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
