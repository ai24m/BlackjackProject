package com.skilldistillery.cards;

import java.util.*;

public abstract class Hand {
	//player and dealer gets own version of Hand aka their own Hand of cards to play 
	protected List<Card> cards = new ArrayList<Card>();
	
	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	public Hand() {}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		getCards().add(card);
	}
	
	public abstract int getHandValue();
	
	public void clearGame() {
		getCards().clear();
	}
	
	@Override
	public String toString() {
		return this.cards.get(0) + ", " + this.cards.get(1) + "]" 
				+ "\n|| Hand Value: " + this.getHandValue();
	}


}
