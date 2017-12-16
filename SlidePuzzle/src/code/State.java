package code;

import java.util.ArrayList;

public class State{
	
	private int[][] _board;
	private int _size;
	
	public State(int m){
		_board = new int[m][m];
		_size = m;
		for(int i = 0; i < m; ++i){
			for(int j= 0; j < m; ++j){
				_board[i][j] = i*m+j;
			}
		}
	}
	
	
	public State[] getChildren(){
		ArrayList<State> l = new ArrayList<State>();
		
		l.add(moveUp());
		l.add(moveDown());
		l.add(moveLeft());
		l.add(moveRight());
		
		
		return (State[]) l.toArray();
	}
	
	
	public State moveUp(){
		int[] coords = find(0);
		if(coords[0] < 1){
			return null;
		}
		int[][] newBoardState = _board.clone();
		
		int temp = _board[coords[0]-1][coords[1]];
		
		newBoardState[coords[0]-1][coords[1]]= 0;
		newBoardState[coords[0]][coords[1]] = temp;
		
		State newBoard = new State(_size);
		
		newBoard.setBoard(newBoardState);
		
		return newBoard;
	}
	
	public State moveDown(){
		int[] coords = find(0);
		if(coords[1] > _board.length -1){
			return null;
		}
		int[][] newBoardState = _board.clone();
		
		int temp = _board[coords[0]+1][coords[1]];
		
		newBoardState[coords[0]+1][coords[1]]= 0;
		newBoardState[coords[0]][coords[1]] = temp;
		
		State newBoard = new State(_size);
		
		newBoard.setBoard(newBoardState);
		
		return newBoard;
	}
	
	public State moveLeft(){
		int[] coords = find(0);
		if(coords[1] < 1){
			return null;
		}
		int[][] newBoardState = _board.clone();
		
		int temp = _board[coords[0]][coords[1]-1];
		
		newBoardState[coords[0]][coords[1]-1]= 0;
		newBoardState[coords[0]][coords[1]] = temp;
		
		State newBoard = new State(_size);
		
		newBoard.setBoard(newBoardState);
		
		return newBoard;
	}
	
	public State moveRight(){
		int[] coords = find(0);
		if(coords[1] > _board[0].length -1){
			return null;
		}
		
		int[][] newBoardState = _board.clone();
		int temp = _board[coords[0]][coords[1]+1];
		
		newBoardState[coords[0]][coords[1] +1 ]= 0;
		newBoardState[coords[0]][coords[1]] = temp;
		
		State newState = new State(_size);
		
		newState.setBoard(newBoardState);
		
		return newState;
	}
	
	protected int[] find(int target){
		for(int i = 0; i < _board.length; ++i){
			for(int j = 0; j < _board[i].length; ++j){
				if(_board[i][j] == target){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}
	
	public boolean compare(State other){
		int[][] otherBoard = other.getBoard();
	    for(int i = 0; i < _board.length; ++i){
	    	for(int j = 0; j < _board[i].length; ++j){
	    		if(otherBoard[i][j] != _board[i][j]){
	    			return false;
	    		}
	    	}
	    }
	    return true;
	}
	
	public int[][] getBoard(){
		return _board;
	}
	
	public void setBoard(int[][] newBoard){
		_board = newBoard;
	}
	
	public int getSize(){
		return _size;
	}
	
}
