package model;

import java.util.ArrayList;
import java.util.Hashtable;


public class State {
	private String name;
	private Hashtable<String, State> transitions;
	private boolean isAcceptState = false;
	private ArrayList<String> alph;

	/**
	 * Public constructor for State objects
	 * 
	 * @param name
	 *            - the name of the state created
	 */
	public State(String name) {
		this.name = name;
		alph = new ArrayList<String>();
		transitions = new Hashtable<String,State>();
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
		alph.add(letter);
		transitions.put(letter, state);
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
	public State getNextState(String letter, boolean debug) {
		if(debug) {this.printState(); System.out.println("Reading letter: "+letter);}
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
	
	
	public void printState(){
		System.out.println("State: "+this.name);
		for(String letter : alph){
			System.out.println("	"+letter+"->"+transitions.get(letter).name);
		}
				
	}
}
