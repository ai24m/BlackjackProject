package com.skilldistillery.cards;

import java.util.*;

public class Player extends Hand{
	
	public Player() {}

	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
			if (handValue > 21 && card.getValue() == 11) {
				handValue -= 10;
			}
		} return handValue;
	}
	
	public void hit(Deck deck) {
		addCard(deck.dealCard());
		System.out.println("Draws card. . . \n||" + getCards() 
		+ "\n||New Hand Value: " + getHandValue()); //check deck size to ensure it is removed from deck! 
	}

	public boolean isBlackjack(Player dealer, Player player) {
		if (player.getHandValue() == 21) { //before calling blackjack check dealer does not 
			System.out.println("|| Dealer reveals card: [" + dealer.toString());
			if (dealer.getHandValue() >= 17) {
				System.out.println("|| Blackjack!!! A natural! We have a WINNER \uD83E\uDD73");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println("Bust!! You lose \u2639\uFE0F");
			return true;
		} else {
			return false; 
		}
	}

	public boolean isPush(Player dealer) {
		if (getHandValue() == dealer.getHandValue()) {
			System.out.println("Maan, a Push.");
		}
		return true;
	}
	
	public void winningConditions(Player dealer, Player player, Deck deck) {
		if (dealer.getHandValue() > player.getHandValue()) {
			System.out.println("Dealer wins \u2639\uFE0F ");
		} else if (player.getHandValue() > dealer.getHandValue() && !player.isBust() || dealer.isBust()) {					
			System.out.println("You win \uD83E\uDD73");					
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("Maan, a Push.");
		} 
	}
}
	
	
