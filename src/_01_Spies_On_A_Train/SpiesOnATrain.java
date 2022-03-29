package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {
		HashMap<String, Integer> possibleSuspects= new HashMap<String, Integer>();
		String spy = "";
		Node<TrainCar> head = train.getHead();
	
		
		for (int i = 0; i < train.size(); i++) {

			for (int j = 0; j < clues.length; j++) {
				

				if (head.getValue().getEvidence().contains(clues[j])) {
					
				
				String[] brokenEvidence=head.getValue().getEvidence().split(" ");
				String person=brokenEvidence[0];
				if(possibleSuspects.containsKey(person)) {
					int value=possibleSuspects.get(person);
					value++;
					possibleSuspects.put(person, value);
				}
				else {
				possibleSuspects.put(person, 1);
				}
				}	
				}
			head=head.getNext();
			}
			
		for(String s: possibleSuspects.keySet()) {
			if(possibleSuspects.get(s)>=3) {
				spy=s;
			}
		}
		

	return spy;

}

}
