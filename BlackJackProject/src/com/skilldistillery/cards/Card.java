package com.skilldistillery.cards;

public class Card {
	private Suit suit; 
	private Rank rank; 
	
	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public int getValue() {
		return rank.getValue();
	}
	
	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return this.suit.toString() + this.rank.toString();
	}
	
}
