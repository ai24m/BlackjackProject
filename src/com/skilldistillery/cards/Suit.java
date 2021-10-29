package com.skilldistillery.cards;

public enum Suit {
	
	HEARTS("\u2666\uFE0F"),
	SPADES("\u2663\uFE0F"),
	CLUBS("\u2660\uFE0F"),
	DIAMONDS("\u2665\uFE0F");
	
	private String name;

	private Suit(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
