/**
   Tyler Whitaker
   CS110
   PlayerDeck class extends Deck and can add or remove cards from the deck.
*/

import java.util.ArrayList;

public class PlayerDeck extends Deck
{
   //Initialize variables
	private final int INITIAL_DECK_SIZE = 26;
	private ArrayList<Card> playerDeck = new ArrayList<Card>();
	public int cardCount;

   /**
      Constructor deals out 26 cars to a player's deck.
   */
	public PlayerDeck(Deck deck)
	{
      //For loop to deal out half of the deck to a player
		for (int i = 0; i <= INITIAL_DECK_SIZE; i++)
		{
         //Use the dealCard method to add the cards to the deck
			Card card = deck.dealCard();
			playerDeck.add(card);
			cardCount++;
		}
	}

   /**
      addCard method adds a card to the players deck.
   */
	public void addCard(Card card)
	{
		playerDeck.add(card);
	}

   /**
      removeCard takes a card away from the players deck.
   */
	public void removeCard(Card card)
	{
		playerDeck.remove(card);
	}
}