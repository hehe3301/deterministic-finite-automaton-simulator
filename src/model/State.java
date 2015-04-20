package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class State {
	private String name;
	private Hashtable<String, State> transitions = new Hashtable<String,State>();
	private boolean isAcceptState = false;

	/**
	 * Public constructor for State objects
	 * 
	 * @param name
	 *            - the name of the state created
	 */
	public State(String name) {
		this.name = name;
	}

	/**
	 * A method to add or update a transition from this state to another
	 * 
	 * @param letter
	 *            - the character to parse
	 * @param state
	 *            - the state the character will cause a transition to
	 */
	public void addTransition(String letter, State state) {
		transitions.put(name, state);
	}

	/**
	 * Method to return the State object of the "next" state based on the letter
	 * given
	 * 
	 * @param letter
	 *            - the letter to be parsed
	 * @return - the State object of the state that should be next based on the
	 *         letter
	 */
	public State getNextState(String letter) {
		return transitions.get(letter);
	}

	/**
	 * "Getter" for the name of the state
	 * 
	 * @return - String name of the state
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method sets the state to be an accepting state
	 */
	public void setAcceptState() {
		isAcceptState = true;
	}

	/**
	 * This method is to check to see if this state is an accepting state
	 * 
	 * @return
	 */
	public boolean isAcceptState() {
		return isAcceptState;
	}
	
	
	public String toString(){
		String out = "State: "+this.name+"\n";
		ArrayList<String> keys = (ArrayList<String>) transitions.keys();
		keys.sort(null);
		for(String trans : keys){
			out+=""+trans+"->"+transitions.get(trans).getName()+"\n";
		}
		return out;
		
	}
}
