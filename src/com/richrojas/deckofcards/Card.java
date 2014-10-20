package com.richrojas.deckofcards;

/**
 * Card class consisting basically of fields that define a
 * playing card. The custom ctor stamps out a single playing
 * card. Details regarding deck size and other deck-related
 * operations are deferred to the Deck class.
 * 
 */
public class Card {
	public final static int SUITS_NUM = 4;
	public final static int RANK_NUM = 13;
	
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS, EMPTY;
		public static Suit get(int i) {
			return values()[i];
		}
	}
	
	public enum Rank {
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		EMPTY;
		public static Rank get(int i) {
			return values()[i]; 
		}
	}
	
	private final Rank rank;
	private final Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "" + getRank() + " of " + getSuit();
	}
	
}
