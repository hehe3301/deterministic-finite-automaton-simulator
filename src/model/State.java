package model;

import java.util.Hashtable;

public class State {
	private String name;
	private Hashtable<String, State> transitions = null;
	private boolean isAcceptState = false;
	
	public State(String name) {
		this.name = name;
	}

	public void addTransition(String letter, State state) {
		transitions.put(name, state);
	}
	
	public State getNextState(String letter){
		return transitions.get(letter);
	}

	public String getName(){
		return this.name;
	}
	
	public void setAcceptState(){
		isAcceptState = true;
	}
	
	public boolean isAcceptState(){
		return isAcceptState;
	}
}
