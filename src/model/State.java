package model;

import java.util.Dictionary;

public class State {
	private String name;
	private Dictionary<String, State> transitions = null;

	public State(String name) {
		this.name = name;
	}

	public void addTransition(String name, State state) {
		transitions.put(name, state);
	}
	
	public State getNextState(String in){
		return transitions.get(in);
	}

}
