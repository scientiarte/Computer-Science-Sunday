package view;
import code.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	private Game _game;
	private JFrame _window;
	private JPanel _statePanel;
	private JPanel _optionsPanel;
	
	public GUI(){
		_game = new Game(this);
		_window = new JFrame("Slide Puzzle!");
		_statePanel = new JPanel();
		_optionsPanel = new JPanel();
		_window.add(_statePanel);
		_window.add(_optionsPanel);
		_window.setLayout(new GridLayout(0,1));
		createOptions();
		update();
	}
	
	private void createOptions(){
		JButton b = new JButton("Solve!");
		b.addActionListener(new SolveListener(_game));
		_optionsPanel.add(b);
	}
	public void update(){
		_statePanel.removeAll();
		//_window.pack();
		_statePanel.setLayout(new GridLayout(_game.getSize(), _game.getSize()));
		
		int[][] board = _game.getBoard();
		
		ButtonListener bListener = new ButtonListener(_game, this);
		
		for(int i = 0; i < board.length; ++i){
			for(int j = 0; j < board[i].length; ++j){
				JButton b = new JButton();
				b.addActionListener(bListener);
				b.setText("" + board[i][j]);
				
				if(board[i][j] == 0){
					b.setBackground(new Color(255,0,0));
				}else{
					b.setBackground(new Color(0,255,0));
				}
				
				b.setFont(new Font("TimesRoman", Font.BOLD, 24));
				
				_statePanel.add(b);
			}
		}
		
		
		_window.setSize(1000,1000);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
