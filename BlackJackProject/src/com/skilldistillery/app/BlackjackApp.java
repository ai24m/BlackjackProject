package com.skilldistillery.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.Deck;
import com.skilldistillery.cards.Player;

public class BlackjackApp {
	Deck deck;
	Player player;
	Player dealer;
	static Scanner kb = new Scanner(System.in);
	String playerInput;

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.printWelcomeMenu();
		ba.getDeck();
	}

	public void getDeck() {
		deck = new Deck();
		deck.generateDeck(); // deck class holds 52 cards not yet called
		deck.shuffle();
		playGame(deck); // send shuffled deck to deal in playgame
//		**check to see if 52 cards prints 
//		System.out.println(deck.getCards()); 
//		System.out.println(deck.deckSize()); 
	}

	public void playGame(Deck deck) {
		dealer = new Player();
		player = new Player();
		// 2 cards per dealer and player
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());

		player.addCard(deck.dealCard());
		player.addCard(deck.dealCard());

		System.out.println(". . . Dealing . . .");
		System.out.println("|| Dealer: [" + dealer.getCards().get(0) + ", \u2370\u2370\u2370]");
		System.out.println("|| " + "Your hand: [" + player.toString());

//		filter out naturals and busts before moving forward with game
		if (player.isBlackjack(dealer, player)) {
			conditions(dealer, player, deck);
			playAgainOrNot();
		} else if (player.isBust()) {
			playAgainOrNot();
		} else {
			hitOrStand(deck);
		}
	}

	public void hitOrStand(Deck deck) {
			System.out.println("Would you like to (1) Hit or (2) Stand?");
			playerInput = kb.nextLine();
			
			switch (playerInput) { 
			case "1": 
				player.hit(deck);
				if (!player.isBust()) {
					conditions(dealer, player, deck);
					playAgainOrNot();
				} else {
					playAgainOrNot();
				}
				break;
				
			case "2":
				conditions(dealer, player, deck);
				playAgainOrNot();
				break;
			default: 
				System.err.println("Try again!");
				hitOrStand(deck);
				break;
			}
		
	}

	public void printWelcomeMenu() {
		System.out.println("┌─────┐ ");
		System.out.println("|#    |  W e l c o m e ");
		System.out.println("|  *  |     t o ");
		System.out.println("|    ?|       B l a c k j a c k");
		System.out.println("└─────┘");
		System.out.println("====================================");
		System.out.println("Please select: ");
		System.out.println("(1) to Begin");
		System.out.println("(2) for Rules");
		System.out.println("(3) to Exit");
		String playerInput = kb.nextLine();

		switch (playerInput) {
		case "1":
			System.out.println("You got this \uD83D\uDCAA");
			getDeck();
			break;
		case "2":
			System.out.println("The goal of blackjack is to beat the dealer without going over 21.\n"
					+ "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.\n"
					+ "Each player starts with two cards, one of the dealer's cards is hidden until the end.\n"
					+ "To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n"
					+ "If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n"
					+ "If you are dealt 21 from the start (Ace & 10), you got a blackjack.\n"
					+ "Dealer will hit until his/her cards total 17 or higher.");
			System.out.println("Lets begin! Good luck \uD83D\uDCAA");
			getDeck();
			break;
		case "3":
			System.out.println("See you next time-");
			break;
		default:
			System.err.println("Try again!\n");
			printWelcomeMenu();
			break;
		}
	}

	public void playAgainOrNot() {
		System.out.println("Would you like to play again? Y/N");
		String playerInput = kb.nextLine();
		switch (playerInput) { 
			case "Y": 
			case "y": 
				player.clearGame();
				getDeck();
			case "n":
			case "N":
				System.out.println("See you next time-");
				kb.nextLine();
				kb.close();
			default:
				System.err.println("Try again!\n");
				playAgainOrNot();
				break;
		}
	}

	public void conditions(Player dealer, Player player, Deck deck) {
		System.out.println("|| Dealer reveals card: [" + dealer.toString());
		if (dealer.getHandValue() < 17) { // when dealer reveals card check if under 17
			dealer.hit(deck); // if under 17 dealer draws
			if (!dealer.isBust()) {
				dealer.winningConditions(dealer, player, deck);
			}
		} else if (dealer.getHandValue() >= 17 && !dealer.isBust()) {
			dealer.winningConditions(dealer, player, deck);
		} else {
			dealer.isBust();
		}
	}
}
