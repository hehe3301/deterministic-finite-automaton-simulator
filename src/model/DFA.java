package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Alex
 *
 */
public class DFA {

	private Hashtable<String, State> states;
	private State startState;
	private String toRead;
	private ArrayList<String> statesArr = new ArrayList<String>();

	public DFA() {
		states = new Hashtable<String, State>();
	}// DFA

	/**
	 * This method adds a transition based on a letter and state to a State
	 * 
	 * @param start
	 *            - the state that the transition is being added to
	 * @param letter
	 *            - the letter of the transition
	 * @param end
	 *            - the state the machine should be in after the
	 */
	public void addTransition(String start, String letter, String end) {
		if (!states.containsKey(start)) {
			states.put(start, new State(start));
			statesArr.add(start);
		}// if
		if (!states.containsKey(end)) {
			states.put(end, new State(end));
			statesArr.add(end);
		}// if
		states.get(start).addTransition(letter, states.get(end));
	}

	/**
	 * This method sets the start state of the machine
	 * 
	 * @param start
	 *            - the name of the state to be set to start
	 */
	public void setStartState(String start) {
		if (!states.containsKey(start)) {
			states.put(start, new State(start));
			statesArr.add(start);
		}// if
		startState = states.get(start);
	}

	/**
	 * This method sets a state an accepting state if it exists or creates it if it does not
	 * @param start - the state to be made accepting
	 */
	public void setAcceptingState(String good) {
		if (!states.containsKey(good)) {
			states.put(good, new State(good));
			statesArr.add(good);
		}// if
		states.get(good).setAcceptState();
	}
	
	public void printStatus(){
		System.out.println("Current state is: " + startState.getName());
		System.out.println("String left to parse is: " + toRead);
	}
	
	public String toString(){
		String out = "";
		System.out.println("Start State is: "+startState.getName());
		
		for(String state : statesArr){
			states.get(state).printState();
		}
		
		return out;
		
	}
	
	/**
	 * this methoid parses a string using the DFA
	 * 
	 * @param stringIn
	 *            - the string to be parsed
	 * @param debug
	 *            - flag if debug messages should be printed
	 * @return - boolean if the string should be accepted or not
	 */
	public boolean parseString(String stringIn, boolean debug) {
		State current = startState;
		toRead = stringIn;
		while (toRead.length() > 1) {
			if(debug) printStatus();
			String head = toRead.substring(0,1);
			toRead = toRead.substring(1, toRead.length());
			current = current.getNextState(head, debug);
		}
		String head = toRead.substring(0);
		current = current.getNextState(head, debug);
		return current.isAcceptState();

	}
}
