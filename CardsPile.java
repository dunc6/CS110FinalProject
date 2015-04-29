/**
   Tyler Whitaker
   CS110
   CardsPile class adds the winning cards to the winners class.
*/

import java.util.ArrayList;

public class CardsPile
{
   //Initialize variables and arraylist
	private int counter;
	private ArrayList<Card> cardsPile;

   /**
      Constructor sets a counter to zero and creates an arraylist called cardsPile
   */
	public CardsPile()
	{
		counter = 0;
		cardsPile = new ArrayList<Card>();
	}

   /**
      addCard method adds the card object thats been drawn to the cardsPile.
      @param Card card
   */
	public void addCard(Card card)
	{
      //Add card to the pile
		cardsPile.add(card);
	}
   
   /**
      emptyPile method removes a card object from cardsPile and adds the card to the players deck.
      @param PlayerDeck pdeck
   */
	public void emptyPile(PlayerDeck pDeck)
	{
		Card card;
		for (int i = 0; i <= cardsPile.size(); i++)
		{
			card = cardsPile.get(i);
			pDeck.addCard(card);
			cardsPile.remove(i);
		}
	}
   
   /**
      getCard method returns cardsPile.get(index)
      @return cardsPile.get(index)
   */
	public Card getCard(int index)
	{
		return cardsPile.get(index);
	}

   /**
      getSize method returns cardsPile.size()
      @return cardsPile.size()
   */
	public int getSize()
	{
		return cardsPile.size();
	}
}