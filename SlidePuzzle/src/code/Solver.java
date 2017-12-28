package code;

import java.util.ArrayList;

public class Solver {

	public static ArrayList<State> BFSSolve(State current, State goal) {
		ArrayList<State> ret = new ArrayList<State>();
		ret.add(current);
		ret.add(goal);
		return ret;
	}
}