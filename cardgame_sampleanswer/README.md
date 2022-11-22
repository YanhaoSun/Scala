## COMP30070 Assignment #2 2022 Card Game

30070_19205434_assgn2
Yanhao Sun
19205434

### What I Achieved

All works correctly, can pass all tests.

This program has three card games, they are Idiot, Liar and Spider.
Each game has two hands that have different number of cards depend on the type of the game.
Each card has different value depends on the type of the game.



### Program Design

1-Card class represents every card and can obtain the type of current card the value of each card depend on different game.
2-Deck class represents current deck, store 13 cards, it can deal card, shuffle cards and print out all cards.
3-Hand class is an abstract class that represents each hand depend on the type of current game.
    Hand class is a superclass, it has three subclasses called IdiotHand, LiarHand and SpiderHand,
    it also has three template methods called addCard, value and toString, two abstract methods called isComplete and computeHandValue
4-Game class is an abstract class that represents each game depend on the type of current game.
    Game class is a superclass, it has three subclasses called IdiotGame, LiarGame and SpiderGame,
    it has two abstract methods called play and result, each subclass will implement these two methods.

Card class:
    Methods in this class: toString, value, obtainCardType
    *toString: prints out the type of current card
    *value: this method takes an Anonymous function as parameter, every time this method is called, 
            the Anonymous function will calculate the value of current card depend on the type of current game
    *obtainCardType: return the type of the current card

Deck class:
    Methods in this class are: dealCard, shuffle, isContained, toString
    *ArrayBuffer is used to store cards of current deck.
    *dealCard: every time this method is called, the first card of the deck is popped out,
               and cards in the deck decreases one, the card been popped out is returned.
    *shuffle: once this method is called, it will firstly check if current deck has cards,
              if yes, it will clear current deck. After that, it regenerates 13 cards by using random number, 
              duplicate cards will be detected by calling method "isContained" and will not be added to the deck.
    *isContained: this is a helper method that takes type of the new generated card as parameter,
                  everytime new card is generated in method "shuffle", the type of the new card is passed in "isContained",
                  if there are duplicate cards, return true, else return false
    *toString: print out cards in current deck

Hand class:
    Methods in super class are: addCard, value and toString
    *ArrayBuffer is used to store cards of each hand.
    *addCard: take Card as parameter and add this card to the hand if there are no duplicate card in this hand and this hand is not complete
    *value: compute values of each hand depend on the type of game
    *toString: print out the sequence of cards on hand
    Subclasses are IdiotHand, LiarHand and SpiderHand,
    Each hand type has one Anonymous function, method computeHandValue and method isComplete
    *computeHandValue: calculate the values of current hand by passing the Anonymous function to each card, 
                       each card will calculate the value of current card and return the value back,
                       method "computeHandValue" will obtain these values and calculate total values of current hand depend on different rules.
    *isComplete: if 5 cards on IdiotHand, IdiotHand is complete, return true, else return false.
                 if 4 cards on LiarHand, LiarHand is complete, return true, else return false.
                 if 3 cards on SpiderHand, SpiderHand is complete, return true, else return false.

Game class:
    Methods in class are: play, result.
    Subclasses are IdiotGame, LiarGame and SpiderGame,
    each subclass will create two hands depend on their own game type.
    *play: deals a card to each hand alternately, starting with hand1, until both hands are complete
    *result: returns a Tuple, the first element is the values of hand1, the second element is the value of the hand2