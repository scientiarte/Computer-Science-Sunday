package code;

import java.util.ArrayList;

import view.GUI;

public class Game {
	private State _currentState;
	private GUI _gui;
	
	
	public Game(GUI g){
		_gui = g;
		_currentState = State.generateRandomState(3);
	}
	public int getSize(){
		return _currentState.getSize();
	}
	public int[][] getBoard(){
		return _currentState.getBoard();
	}
	public void reset(){
		_currentState = new State(_currentState.getSize());
	}
	
	public void setSize(int m){
		_currentState = new State(m);
	}
	
	public void moveUp(){
		State n = _currentState.moveUp();
		if(n != null){
			_currentState = n;
		}
	}
	
	public void moveDown(){
		_currentState = _currentState.moveDown();
	}
	
	public void moveLeft(){
		_currentState = _currentState.moveLeft();
	}
	
	public void moveRight(){
		_currentState = _currentState.moveRight();
	}
	
	public void swap(int a, int b) {
		if(a != 0 && b != 0){
			return;
		}
		//[row, column]
		int[] zeroCoord;
		int[] otherCoord;
		if(a == 0){
			zeroCoord = _currentState.find(a);
			otherCoord = _currentState.find(b);
		}else{
			otherCoord = _currentState.find(a);
			zeroCoord = _currentState.find(b);
		}
		
		
		
		int rowChange = otherCoord[0] - zeroCoord[0];
		int columnChange = otherCoord[1] - zeroCoord[1];
		
		if(rowChange == 0 && Math.abs(columnChange) == 1){
			if(columnChange == 1){
				moveRight();
			}
			if(columnChange == -1){
				moveLeft();
			}
		}
		if(columnChange == 0 && Math.abs(rowChange) == 1){
			if(rowChange == 1){
				moveDown();
			}
			if(rowChange == -1){
				moveUp();
			}
		}
	}
	
	public State getGoal(){
		State s = new State(getSize());
		return s;
	}
	
	
	
	public void solve() {
		ArrayList<State> steps = Solver.BFSSolve(_currentState, getGoal());
		for(State s: steps){
			_currentState = s;
			
			//TimeDelay
			
			_gui.update();
		}
	}
}
