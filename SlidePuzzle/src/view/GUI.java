package view;
import code.*;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {
	private Game _game;
	private JFrame _window;
	
	public GUI(){
		_game = new Game();
		_window = new JFrame("Slide Puzzle!");
		update();
	}
	
	public void update(){
		_window.dispose();
		_window.pack();
		_window.setLayout(new GridLayout(_game.getSize(), _game.getSize()));
		
		int[][] board = _game.getBoard();
		
		ButtonListener bListener = new ButtonListener(_game, this);
		
		for(int i = 0; i < board.length; ++i){
			for(int j = 0; j < board[i].length; ++j){
				JButton b = new JButton();
				b.addActionListener(bListener);
				b.setText("" + board[i][j]);
				_window.add(b);
			}
		}
		_window.pack();
		_window.setSize(1000,1000);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
