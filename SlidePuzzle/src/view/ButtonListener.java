package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import code.Game;


public class ButtonListener implements ActionListener{

	private String _pressed;
	private Game _game;
	private GUI _gui;
	
	public ButtonListener(Game g, GUI gui){
		_game = g;
		_gui = gui;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(_pressed == null){
			_pressed = ((JButton) e.getSource()).getText();
			return;
		}
		
		//Second button pressed
		JButton secondPressed = (JButton) e.getSource();
		int pressedText = new Integer(secondPressed.getText());
		
		int firstPressedText = new Integer(_pressed);
		
		_game.swap(pressedText, firstPressedText);
		
		_gui.update();
		
		_pressed = null;
	}

}