package tests;

import model.DFA;

public class TestDFA {

	public static void main(String[] args) {
		DFA dfa = new DFA();
		dfa.setStartState("I");
		dfa.addTransition("I", "a", "II");
		dfa.addTransition("I", "b", "III");
		dfa.addTransition("II", "a", "I");
		dfa.addTransition("II", "b", "IV");
		dfa.addTransition("III", "a", "IV");
		dfa.addTransition("III", "b", "I");
		dfa.addTransition("IV", "a", "III");
		dfa.addTransition("IV", "b", "II");
		dfa.setAcceptingState("III");
		System.out.println(dfa);
		System.out.println("Test string 'aba' true:" +dfa.parseString("aba", false));
		System.out.println("Test string 'abab' false:" +dfa.parseString("abab", false));
		System.out.println("Test string 'ababbabab' true:" +dfa.parseString("ababbabab", false));
		
		
		

	}

}
