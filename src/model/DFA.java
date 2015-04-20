package model;

import java.util.Hashtable;

/**
 * @author Alex
 *
 */
public class DFA {

	public Hashtable<String, State> states;
	public State startState;

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
		if (!states.contains(start)) {
			states.put(start, new State(start));
		}// if
		if (!states.contains(end)) {
			states.put(end, new State(end));
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
		if (!states.contains(start)) {
			states.put(start, new State(start));
		}// if
		startState = states.get(start);
	}

	/**
	 * This method sets a state an accepting state if it exists or creates it if it does not
	 * @param start - the state to be made accepting
	 */
	public void setAcceptingState(String good) {
		if (!states.contains(good)) {
			states.put(good, new State(good));
		}// if
		states.get(good).setAcceptState();
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
		String toRead = stringIn;
		while (toRead.length() > 1) {
			String head = toRead.substring(0, 0);
			toRead = toRead.substring(1, toRead.length() - 1);
			current = current.getNextState(head);
		}
		String head = toRead.substring(0);
		current = current.getNextState(head);
		return current.isAcceptState();

	}
}
