package model;

import java.util.Hashtable;

public class DFA {

	
	public Hashtable<String,State> states;
	public State startState;
	
	public DFA(){
		states= new Hashtable<String,State>();
	}//DFA
	
	public void addTransition(String start,String letter, String end){
		if(!states.contains(start)){
			states.put(start, new State(start));
		}//if
		if(!states.contains(end)){
			states.put(end, new State(end));
		}//if
		states.get(start).addTransition(letter, states.get(end));
	}
	
	public void setStartState(String start){
		startState = states.get(start);
	}
	
	public boolean parseString(String stringIn){
		State current = startState;
		String toRead = stringIn;
		while(toRead.length()>1){
			String head = toRead.substring(0,0);
			toRead = toRead.substring(1, toRead.length()-1);
			current=current.getNextState(head);
		}
		String head = toRead.substring(0);
		current=current.getNextState(head);
		return current.isAcceptState();
		
	}
}
