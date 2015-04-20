package model;

import java.util.Hashtable;

public class DFA {

	public String toRead = new String();
	public Hashtable<String,State> states;
	
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
	
	public boolean 
}
