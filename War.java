/*
	Tyler Whitaker
	CS 110
	War class sets up a game of war.
*/

import java.util.ArrayList;

public class War
{
   //Initialize variables
	private final int NUM_WAR_DRAWS = 2;	
	public static String winner = "none";

   /**
      Constructor creates the players, the deck they'll use, and deals their cards.
   */
	public War()
	{
		//Create two players
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
      
		//Create deck to use for the game
		Deck deck = new Deck();
      
		//Shuffle the deck
		deck.shuffle();
      
		//Deal 26 cards to each player
		PlayerDeck deck1 = new PlayerDeck(deck);
		PlayerDeck deck2 = new PlayerDeck(deck);
      
		//Shuffle each player's cards
		deck1.shuffle();
		deck2.shuffle();
      
		//Create piles for each player winning cards
		CardsPile pile1 = new CardsPile();
		CardsPile pile2 = new CardsPile();
	}

	/**
      winner method checks if either player has run out of cards.
      @return War.winner 
   */
	public String winner(Player player1, Player player2, PlayerDeck deck1, PlayerDeck deck2)
	{
      //Check if either players deck is empty
		if (deck1.cardCount == 0 || deck2.cardCount == 0)
		{
			//If player ones deck is empty player 2 wins
			if (deck1.cardCount == 0)
			{
				War.winner = player2.getName();
			}
         
         //Else player 1 wins
			else
			{
				War.winner = player1.getName();
			}
		}

      //return the winner
		return War.winner;
	}

	/**
      nextTurn no loser
   */
	public void nextTurn(PlayerDeck deck1, PlayerDeck deck2, CardsPile pile1, CardsPile pile2)
	{
   	//deal cards and compare
   	Card p1Card = deck1.dealCard();
   	Card p2Card = deck2.dealCard();
   	
      //higher card wins, winning player gets both cards
   	if (p1Card.getRank() > p2Card.getRank())
   	{
   		pile1.addCard(p1Card);
   		pile1.addCard(p2Card);
         
   		//remove cards from player decks
   		deck1.removeCard(p1Card);
   		deck2.removeCard(p2Card);
   	}
   
   	else if (p1Card.getRank() < p2Card.getRank())
   	{
   		deck2.addCard(p1Card);
   		deck2.addCard(p2Card);
         
   		//revove cards from player decks
   		deck1.removeCard(p1Card);
   		deck2.removeCard(p2Card);
   	}
   
   	//if cards are equal, initiate war
   	else
   	{
   		initiateWar(pile1, pile2, deck1, deck2);
   	}
	
	}

	public void initiateWar(CardsPile pile1, CardsPile pile2, PlayerDeck deck1, PlayerDeck deck2)
	{
		//create piles to hold war cards during war resolution
		CardsPile warPile1 = new CardsPile();
		CardsPile warPile2 = new CardsPile();
		//create count variable to hold index of every 2rd card in event of multiple consecutive wars
		int warCount = 2;
		//create accumulator for adding war cards to winner's pile
		int ct = 0;
		
		dealWar(deck1, deck2, warPile1, warPile2);

		//if still war, continue again and again until resolved
		while ( (warPile1.getCard(warCount)).equals(warPile2.getCard(warCount)) )
		{
			warCount += 3;
			dealWar(deck1, deck2, warPile1, warPile2);
		}

		if ((warPile1.getCard(warCount)).getRank() > (warPile2.getCard(warCount)).getRank())
		{
			for (int i = 0; i <= warPile1.getSize(); i++)
			{
				Card cd = warPile1.getCard(ct);
				pile1.addCard(cd);
				cd = warPile2.getCard(ct);
				pile2.addCard(cd);
			}
		}

		else if ((warPile1.getCard(warCount)).getRank() < (warPile2.getCard(warCount)).getRank())
		{
			for (int i = 0; i <= warPile1.getSize(); i++)
			{
				Card cd = warPile1.getCard(ct);
				pile2.addCard(cd);
				cd = warPile2.getCard(ct);
				pile2.addCard(cd);
			}
		}
	}

	/**
	   dealWar() method deals 2 cards to each player in event of war.
	*/
	public void dealWar(PlayerDeck deck1, PlayerDeck deck2, CardsPile warPile1, CardsPile warPile2)
	{
		Card warCard1;
		Card warCard2;
		for (int i = 0; i <= NUM_WAR_DRAWS; i++)
		{
			warCard1 = deck1.dealCard();
			warPile1.addCard(warCard1);

			warCard2 = deck2.dealCard();
			warPile2.addCard(warCard2);
		}
	}
		
	
}