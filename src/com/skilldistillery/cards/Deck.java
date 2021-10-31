package com.skilldistillery.cards;
import java.util.*; 

public class Deck {
	private List<Card> cards = new ArrayList<>(52);
	
	public Deck(List<Card> cards) {
		super();
		this.cards = cards;
	}

	public Deck() {}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	//generate deck  
	public void generateDeck() { 
		for (Suit suit : Suit.values()) { //four suits x fourteen ranks 
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank)); //Card pairs suit to rank 
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card dealCard() {//returns a single card
		return cards.remove(0);
	}
	
	public int deckSize() {
		return cards.size();	
	}
	
	
 }


