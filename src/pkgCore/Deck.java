package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();
	
	private eSuit Suit;
	private eRank Rank;

	public Deck() {
		
		
		
		
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	
	
	//Method Implemented to count suits and ranks.
	public void getRemaining(Object eNum) {
		
		int countCard_1 = 0;
		int countCard_2 = 0;
		
		if(eNum instanceof eSuit) {
			this.Suit = (eSuit) Suit;
			
			for( Card c : cardsInDeck) {
				
				if(c.geteSuit() == eNum) {
					
					countCard_1++;
				}
			}
			
		}
		
		if(eNum instanceof eRank) {
			
			 this.Rank = (eRank) Rank;
			
			for( Card c : cardsInDeck) {
				
				if(c.geteSuit() == eNum) {
					
					countCard_2++;
				}
			}
			
			
		}
		
	}
}
	

