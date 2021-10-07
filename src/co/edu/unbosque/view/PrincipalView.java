/**
 * Package containing the class
 */

package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author  Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago Acevedo.
 *
 */
public class PrincipalView extends JFrame {
	
	/**
	 * background1, sourceBackground, imageButton1, sourceButton1, imageButton2, sourceButton2, imageButton3, sourceButton3, imageButton4, sourceButton4 are ImageIcon type.
	 */
	
	private ImageIcon background1, sourceBackground, imageButton1, sourceButton1, imageButton2, sourceButton2,
	imageButton3, sourceButton3, imageButton4, sourceButton4;
	
	/**
	 * imageBackground is JLabel type.
	 */
	
	private JLabel imageBackground;
	
	/**
	 * button1, button2 are TypeButton type.
	 */
	
	private TypeButton button1, button2;
	
	/**
	 * minimize and close are JButton type.
	 */
	
	private JButton minimize, close;
	
	/**
	 *  Constructor of the class in which the different components are initialized together with the method of initializing components for its operation, these components are of JFrame and those of the method.
	 *  <b>pre</b>It must contain the components of the frame so that the window can be seen.<br>
	 *  <b>post</b>The components that were entered in the constructor are displayed.<br>
	 */

	public PrincipalView() {

		setTitle("Words searcher");
		setSize(600, 300);
		setUndecorated(true);
		setIconImage(new ImageIcon("images/logo.png").getImage());
		initializeComponents();
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void initializeComponents() {
		
		imageButton1 = new ImageIcon("images/minimize.png");
		sourceButton1 = new ImageIcon(imageButton1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		minimize = new JButton();
		minimize.setBounds(550, 5, 20, 20);
		minimize.setBorderPainted(false);
		minimize.setContentAreaFilled(false);
		minimize.setFocusPainted(false);
		minimize.setIcon(sourceButton1);
		minimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimize.setActionCommand("WINDOWMINIMIZE");
		add(minimize);
		
		imageButton2 = new ImageIcon("images/close.png");
		sourceButton2 = new ImageIcon(imageButton2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		close = new JButton();
		close.setBounds(575, 5, 20, 20);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setFocusPainted(false);
		close.setIcon(sourceButton2);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.setActionCommand("WINDOWCLOSE");
		add(close);
		
		imageButton3 = new ImageIcon("images/selectFile.png");
		sourceButton3 = new ImageIcon(imageButton3.getImage().getScaledInstance(166, 49, Image.SCALE_DEFAULT));
		button1 = new TypeButton();
		button1.setBounds(200, 150, 166, 49);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.setIcon(sourceButton3);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button1.setActionCommand("INFILE");
		add(button1);
		

		background1 = new ImageIcon(getClass().getResource("/images/background.png"));
		sourceBackground = new ImageIcon(background1.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH));
		imageBackground = new JLabel(sourceBackground);
		imageBackground.setSize(600, 300);
		add(imageBackground);
		
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
}
