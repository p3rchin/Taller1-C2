/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * 
 * @author Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago
 *         Acevedo.
 *
 */

public class TypeButton extends JButton {
	/*
	 * opacity is of type float.
	 */
	float opacity = 0.9f;

	/**
	 * Specific constructor of the Button class where it has a String parameter and contains a method.  
	 * <b>pre</b>The String parameter must be entered.<br>
	 * <b>post</b>A listener is added to the button when hovering over it.<br>
	 * @param text of String type: text must be != of null and != of " ".
	 */
	public TypeButton(String text) {
		super(text);
		addMouseListener(new EventButton());
	}

	/**
	 * Specific constructor of the Button class where it contains a method for listening to the mouse. 
	 * <b>pre</b>The method must be added inside the constructor for it to work.<br>
	 * <b>post</b>A listener is added to the button.<br>
	 */
	public TypeButton() {
		super();
		addMouseListener(new EventButton());
	}

	/**
	 * @return the opacity
	 */
	public float getOpacity() {
		return opacity;
	}

	/**
	 * @param opacity the opacity to set
	 */
	public void setOpacity(float opacity) {
		this.opacity = opacity;
		repaint();
	}

	/**
	 * Method that receives a parameter of type Graphics. It gives the necessary graphics to the buttons so that their opacity can be seen. 
	 * <b>pre</b> You have to send the parameter to make your opacity work.<br>
	 * <b>post</b>Opacity is added.<br>
	 * @param g is of type Graphics.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		super.paintComponent(g2);
	}

	/**
	 * EventButton class that extends MouseAdapter to complete the actions that are added to the button.
	 * 
	 * @author Santiago Porras, Fabian Camilo Gomez, Omar Felipe Ladino y Santiago Acevedo.
	 *
	 */
	public class EventButton extends MouseAdapter {
		/**
		 * Method that receives a parameter to see if the mouse has left the button and make it opaque.
		 *  <b>pre</b>The variable me must be added to the method for it to work.<br>
		 * <b>post</b>The opacity effect is added when exiting the button.<br>
		 */
		@Override
		public void mouseExited(MouseEvent me) {
			efectHover(1f, 0.5f, 0.03f, 10, false);
		}

		/**
		 * Method that receives a parameter to see if the mouse has entered the button and return it clear. 
		 * <b>pre</b>The variable me must be added to the method for it to work.<br>
		 * <b>post</b> Clarity effect is added when exiting the button.<br>
		 */
		@Override
		public void mouseEntered(MouseEvent me) {
			efectHover(0.5f, 1f, 0.03f, 10, true);
		}

		/**
		 * Method that receives a parameter to see if the mouse has selected the button and give it the animation.
		 *  <b>pre</b> The method must be added to the variable for it to work.<br>
		 * <b>post</b> The effect is added when the button is selected.<br>
		 */
		@Override
		public void mousePressed(MouseEvent me) {
			efectHover(1f, 0.6f, 0.1f, 1, false);
		}

		/**
		 * Method to verify the parameters being entered and that they can comply with the above methods.
		 * <b>pre</b>Parameters must be entered for the method to perform the following actions<br>
		 * <b>post</b>The animation needed for the button is applied.<br>
		 * @param index is of type float: index is 0 <= i.
		 * @param range is of type float: range is 0 <= i.
		 * @param cont  is of type float: cont is 0 <= i.
		 * @param sleep is of type int: must be != 0.
		 * @param event is of type boolean: can have the values true or false.
		 */
		
		private void efectHover(float index, float range, float cont, int sleep, boolean event) {
			new Thread(() -> {
				for (float i = index; (event) ? i <= range : i >= range; i = (event) ? i + cont : i - cont) {
					setOpacity(i);
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
					}

				}
			}).start();
		}
	}

}