package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> zombie=new Node<Zombie>(dancer);
    	congaLine.setHead(zombie);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> zombie=new Node<Zombie>(dancer);
    	congaLine.setTail(zombie);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> zombie=new Node<Zombie>(dancer);
    	Node<Zombie> current=congaLine.getHead();
    	for(int i=0; i<position; i++) {
    		current=current.getNext();
    	}
    	Node<Zombie> prev=current.getPrev();
    	prev.setNext(zombie);
    	current.setPrev(zombie);
    	zombie.setNext(current);
    	zombie.setPrev(prev);
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> current=congaLine.getTail();
    	for(int i=congaLine.size()-1; i>=0; i--) {
    		if(current.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
    			congaLine.remove(i);
    			
    		}
    		current=current.getPrev();
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> current=congaLine.getHead();
    	
    	for(int i=0; i<congaLine.size(); i++) {
    		if(current.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
    			congaLine.remove(i);
    			break;
    		}
    		else {
    			current=current.getNext();
    		}
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Node<Zombie> headZombie=new Node<Zombie>(new Zombie(dancer.getZombieHatColor()));
    	Node<Zombie> middleZombie=new Node<Zombie>(dancer);
    	Node<Zombie> endZombie=new Node<Zombie>(new Zombie(dancer.getZombieHatColor()));
    	Node<Zombie>head=congaLine.getHead();
    	headZombie.setNext(head);
    	head.setPrev(headZombie);
    	congaLine.setHead(headZombie);
    	Node<Zombie> tail=congaLine.getTail();
    	endZombie.setPrev(tail);
    	congaLine.setTail(endZombie);
    	tail.setNext(endZombie);
    	middleZombie.setNext(head.getNext());
    	head.setNext(middleZombie);
    	//DO SIMILAR THING FOR END AND THEN MIDDLE THING IS DIFFERENT 
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	Node<Zombie> headZombie=new Node<Zombie>(dancer);
    	Node<Zombie> head=congaLine.getHead();
    	headZombie.setNext(head);
    	if(head!=null) {
    	head.setPrev(headZombie);
    	}
    	else {
    		congaLine.setTail(headZombie);
    	}
    	congaLine.setHead(headZombie);
    	for(int i=0; i<zombieHats.length; i++) {
    		Node<Zombie> hi=new Node<Zombie>(new Zombie(zombieHats[i]));
    		Node<Zombie> tail=congaLine.getTail();
    		hi.setPrev(tail);
    		tail.setNext(hi);
    		congaLine.setTail(hi);
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
