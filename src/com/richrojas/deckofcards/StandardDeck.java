package com.richrojas.deckofcards;

/**
 * A standard 52 card deck sub-classed from Deck.
 *
 */
public class StandardDeck extends Deck {

	/**
	 * Generates a deck consisting of four suits of 13 rank cards each.
	 */
	@Override
	public void createDeck() {
		for (int i = 0; i < Card.SUITS_NUM; i ++) {
			for (int j = 0; j < Card.RANK_NUM; j++) {
				deck.add(new Card(Card.Rank.get(j), Card.Suit.get(i)));
			}
		}	
	}
	
}
