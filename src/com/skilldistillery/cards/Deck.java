package com.skilldistillery.cards;

import java.util.*;

public class Deck {
	private List<Card> deck;

	public Deck(List<Card> deck) {
		deck = generateDeck();
	}

	public List<Card> generateDeck() { // generate deck
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) { // four suits x fourteen ranks
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank)); // Card pairs suit to rank
			}
		}
		return deck;
	}

	public Deck() {
	}

	public List<Card> getCards() {
		return deck;
	}

	public void setCards(List<Card> cards) {
		this.deck = cards;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {// returns a single card
		return deck.remove(0);
	}

	public int deckSize() {
		return deck.size();
	}
}
