package com.richrojas.deckofcards;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * Abstract base class for Deck objects. This class is abstract
 * since there are potentially different kinds of decks with 
 * various sizes (cards and number of decks): pinochle and
 * multi-deck blackjack shoes.
 *
 */
public abstract class Deck {
	private final int deckSize = Card.RANK_NUM * Card.SUITS_NUM;
	
	/** Container for the deck. A Deque has similar behavior to a card deck */
	protected Deque<Card> deck = new LinkedList<Card>();
	
	/** Override this in subclasses to create specific sized decks */
	public void createDeck() {}
	
	public int getSize() {
		return deckSize;
	}
	
	/**
	 * Casts Deque container to a LinkedList and leverages indexed
	 * access to shuffle cards. Employs a random number generator
	 * to implement the shuffle by randomly selecting a card via
	 * the randomly generated index and rearranging it in a temporary list.
	 */
	public void shuffle() {
		// Current size of the deck -- update as cards are removed
		int count = deck.size() - 1;
		int idx;
		
		// Temporary LL to hold shuffled cards
		LinkedList<Card> list = new LinkedList<Card>();			
		while (count > 0) {		
			// Randomly generate an index inclusive of remaining cards in deck
			idx = randInt(0, count--);
			// Treat deck polymorphically in order to access elements 
			// via index for both get and remove operations.
			list.add(getCard(idx));
			// Remove the card in the main deck
			removeCard(idx);
		}
		// Remove last card and insert into shuffled list
		list.add(getCard(0));
		removeCard(0);
		
		// Assign the shuffled list of card to the main deck
		deck = list;
	}
	
	/**
	 * Returns the card from the top of the deck and also
	 * removes it from the deck (Deque behavior). If deck
	 * is empty, then creates the an EMPTY Card object to be
	 * returned.
	 * 
	 * @return Card - the card from the top of the deck
	 */
	public Card dealOneCard() {
		// check if deck is empty, if it is, then return "empty card" object
		if (deck.isEmpty())
			return new Card(Card.Rank.EMPTY, Card.Suit.EMPTY);
		else
			return deck.remove();
	}
	
	/**
	 * Treats deck as a LinkedList to retrieve a card by index.
	 * Used by shuffle(), but can also be called by clients
	 * wishing to draw cards from inside the deck.
	 * 
	 * @param index
	 * @return
	 */
	public Card getCard(int index) {
		return ((LinkedList<Card>)deck).get(index);
	}
	
	/**
	 * Same principle as getCard, but also removes the returned
	 * card from inside the deck.
	 * 
	 * @param index
	 * @return
	 */
	public Card removeCard(int index) {
		return ((LinkedList<Card>)deck).remove(index);
	}
	
	/**
	 * Utility method to generate an inclusive random index for the shuffle() method.
	 * 
	 * From: http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	protected static int randInt(int min, int max) {
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}