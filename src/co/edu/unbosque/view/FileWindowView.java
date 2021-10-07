/**
 * Package containing the class
 */

package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 * 
 * @author Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago Acevedo.
 *
 */
public class FileWindowView extends JFrame {

	
	/**
	 * background1, sourceBackground, imageButton1, sourceButton1, imageButton2, sourceButton2, imageButton3, sourceButton3, imageButton4, sourceButton4, imageButton5, sourceButton5 are ImageIcon type.
	 */
	private ImageIcon background1, sourceBackground, imageButton1, sourceButton1, imageButton2, sourceButton2,
			imageButton3, sourceButton3, imageButton4, sourceButton4, imageButton5, sourceButton5;
	/**
	 * imageBackground, image are JLabel type.
	 */
	private JLabel imageBackground, image;
	/**
	 * button1, button2, button3, button4 are TypeButton type.
	 */
	private TypeButton button1, button2, button3, button4;
	/**
	 * searchButton, returnButton, minimize, close are JButton type.
	 */
	private JButton searchButton, returnButton, minimize, close;
	/**
	 * tittle1 is JLabel type.
	 */
	private JLabel title1;
	/**
	 * textAreaShow, estadisticText are JTexArea type.
	 */
	private JTextArea textAreaShow, estadisticText;
	/**
	 * textSearch is JTextField type.
	 */
	private JTextField textSearch;
	/**
	 * scrollPane is JScrollPane type.
	 */
	private JScrollPane scrollPane;
	/**
	 * fileChooser is JFileChooser type.
	 */
	private JFileChooser fileChooser;
	/**
	 * option is JComboBox type.
	 */
	private JComboBox<String> option;
	/**
	 * text is String type.
	 */
	String text;

	/**
	 *  Constructor of the class in which the different components are initialized together with the method of initializing components for its operation, these components are of JFrame and those of the method.
	 *  <b>pre</b>It must contain the components of the frame so that the window can be seen.<br>
	 *  <b>post</b>The components that were entered in the constructor are displayed.<br>
	 */
	
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

	/**
	 *  Constructor of the class in which the different components are initialized together with the method of initializing components for its operation, these components are of JFrame and those of the method.
	 *  <b>pre</b>The attributes must be added in the method to initialize them and add them in the window, together with the panels must be initialized.<br>
	 *  <b>post</b>The initialized components will be added in the window to be able to select and have an interface.<br>
	 */
	
	public void initialize() {

		fileChooser = new JFileChooser();

		title1 = new JLabel("Enter the word to search");
		title1.setBounds(260, 2, 400, 50);
		title1.setFont(new Font("Arial", Font.CENTER_BASELINE, 22));
		add(title1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 765, 350);
		add(scrollPane);

		ImageIcon im1 = new ImageIcon(getClass().getResource("/images/lupa.png"));
		ImageIcon ic1 = new ImageIcon(im1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

		image = new JLabel(ic1);
		image.setBounds(102, 60, 20, 20);
		image.setVisible(true);
		add(image);

		textSearch = new JTextField();
		textSearch.setFont(new Font("Arial", Font.ROMAN_BASELINE, 12));
		textSearch.setBounds(129, 60, 200, 20);
		add(textSearch);

		option = new JComboBox<String>();
		option.addItem("Select the algorithm");
		option.addItem("BM");
		option.addItem("KMP");
		option.setFont(new Font("Arial", Font.ROMAN_BASELINE, 12));
		option.setBounds(340, 60, 140, 20);
		add(option);

		imageButton4 = new ImageIcon("images/searchButton.png");
		sourceButton3 = new ImageIcon(imageButton4.getImage().getScaledInstance(92, 20, Image.SCALE_DEFAULT));
		button1 = new TypeButton();
		button1.setBounds(490, 60, 92, 20);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.setIcon(sourceButton3);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button1.setActionCommand("SEARCHWORD");
		add(button1);

		textAreaShow = new JTextArea();
		textAreaShow.setPreferredSize(new Dimension(800, 400));
		textAreaShow.setEditable(false);
		textAreaShow.setBackground(Color.white);
		textAreaShow.setFont(new Font("Verdama", Font.ROMAN_BASELINE, 14));
		textAreaShow.setLineWrap(true);
		scrollPane.setViewportView(textAreaShow);
		add(scrollPane);

		estadisticText = new JTextArea();
		estadisticText.setBounds(25, 465, 230, 20);
		estadisticText.setFont(new Font("Verdama", Font.ROMAN_BASELINE, 15));
		estadisticText.setBackground(new Color(244, 137, 42));
		estadisticText.setEditable(false);
		estadisticText.setLineWrap(true);
		add(estadisticText);
		
		imageButton5 = new ImageIcon("images/cleanButton.png");
		sourceButton5 = new ImageIcon(imageButton5.getImage().getScaledInstance(92, 28, Image.SCALE_DEFAULT));
		button4 = new TypeButton();
		button4.setBounds(280, 462, 92, 28);
		button4.setBorderPainted(false);
		button4.setContentAreaFilled(false);
		button4.setFocusPainted(false);
		button4.setIcon(sourceButton5);
		button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button4.setActionCommand("CLEANTEXT");
		add(button4);

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
	/**
	 * The initialized components will be added in the window to be able to select and have an interface.
	 * <b>pre</b>There must be a text, the list of its index and the word to be searched.<br>
	 * <b>post</b>If everything is correct, the text is painted in the JTextArea.<br>
	 * @param part is String type: part must be != null and != " ".
	 * @param list is ArrayList type: list must be != null and != " ". 
	 * @param textArea is JTextArea type: textArea must be != null.
	 * @throws BadLocationException is the exception for the highlight method.
	 */

	public void highlightText(String part, ArrayList<Integer> list, JTextArea textArea,Color color) throws BadLocationException {
		Highlighter highlighter = textArea.getHighlighter();
		HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(color);
		for (int i = 0; i < list.size() - 1; i++) {
			highlighter.addHighlight(list.get(i), (list.get(i) + part.length()), painter);
		}

	}

	/**
	 * This method is for inserting and reading the txt file.
	 * <b>pre</b>The file must be txt and contain<br>
	 * <b>post</b>The file is converted to String type.<br>
	 * @return The String of the file.
	 */

	public String openFileToSearch() {

		String aux = "";
		text = "";

		try {

			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			fileChooser.setFileFilter(filter);
			fileChooser.showOpenDialog(this);

			File open = fileChooser.getSelectedFile();

			if (open != null && open.getName().endsWith("txt")) {
				FileReader archive = new FileReader(open);
				BufferedReader read = new BufferedReader(archive);
				while ((aux = read.readLine()) != null) {
					text += aux + "\n";
				}

				read.close();
			} else {
				JOptionPane.showMessageDialog(null, "\nChoose a correct file (txt)", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		return text;
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
	 * @return the imageButton5
	 */
	public ImageIcon getImageButton5() {
		return imageButton5;
	}

	/**
	 * @param imageButton5 the imageButton5 to set
	 */
	public void setImageButton5(ImageIcon imageButton5) {
		this.imageButton5 = imageButton5;
	}

	/**
	 * @return the sourceButton5
	 */
	public ImageIcon getSourceButton5() {
		return sourceButton5;
	}

	/**
	 * @param sourceButton5 the sourceButton5 to set
	 */
	public void setSourceButton5(ImageIcon sourceButton5) {
		this.sourceButton5 = sourceButton5;
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
	 * @return the image
	 */
	public JLabel getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(JLabel image) {
		this.image = image;
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
	 * @return the button4
	 */
	public TypeButton getButton4() {
		return button4;
	}

	/**
	 * @param button4 the button4 to set
	 */
	public void setButton4(TypeButton button4) {
		this.button4 = button4;
	}

	/**
	 * @return the searchButton
	 */
	public JButton getSearchButton() {
		return searchButton;
	}

	/**
	 * @param searchButton the searchButton to set
	 */
	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
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
	 * @return the estadisticText
	 */
	public JTextArea getEstadisticText() {
		return estadisticText;
	}

	/**
	 * @param estadisticText the estadisticText to set
	 */
	public void setEstadisticText(JTextArea estadisticText) {
		this.estadisticText = estadisticText;
	}

	/**
	 * @return the textSearch
	 */
	public JTextField getTextSearch() {
		return textSearch;
	}

	/**
	 * @param textSearch the textSearch to set
	 */
	public void setTextSearch(JTextField textSearch) {
		this.textSearch = textSearch;
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
	 * @return the option
	 */
	public JComboBox<String> getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(JComboBox<String> option) {
		this.option = option;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}
