package com.richrojas.deckofcards;

public class Program {

	/**
	 * Test harness.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Card card = null;
		// Create one standard deck
		Deck deck = new StandardDeck();
		deck.createDeck();
		
		System.out.println("Test dealing from new, unshuffled deck...");
		System.out.println("");
		
		for (int i = 0; i < deck.getSize(); i++) {
			card = deck.dealOneCard();		
			System.out.println(card.toString());
		}
		System.out.println("");
		System.out.println("Test for empty deck...");
		card = deck.dealOneCard();		
		System.out.println(card.toString());
		System.out.println("");
		
		// Create new standard deck
		deck = new StandardDeck();
		deck.createDeck();
		
		// Shuffle the deck...
		deck.shuffle();
		
		System.out.println("Test dealing from new, shuffled deck...");
		System.out.println("");
		for (int i = 0; i < deck.getSize(); i++) {
			card = deck.dealOneCard();		
			System.out.println(card.toString());
		}
		System.out.println("");
		System.out.println("Test for empty deck...");
		card = deck.dealOneCard();		
		System.out.println(card.toString());
	}

}
