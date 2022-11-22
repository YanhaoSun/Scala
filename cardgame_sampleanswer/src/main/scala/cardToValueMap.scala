
/* CardToValueMap stores the mapping from card to value. Each card game will
   use its own mapping. Note that a CardToValueMap is simply a mapping from Card
   to value, and be represented by a function. EXERCISE: Read about anonymous 
   functions and try using fuctions here rather than classes. */

trait CardToValueMap:
  def value(card: Card): Int

object IdiotCardValues extends CardToValueMap:
  def value(card: Card): Int = card.cardType.ordinal + 1

// Note the use of Deck.fullDeckSize. Hardcoding 13 is less clear as the reader won't
// know what 13 means and it will make changing the Deck size difficult.
object LiarCardValues extends CardToValueMap:
  def value(card: Card): Int = Deck.fullDeckSize - card.cardType.ordinal

// By contrast, the meaning of the "magic numbers" in this method are clear -- they
// simply express the rules of the game
object SpiderCardValues extends CardToValueMap:
  def value(card: Card): Int =
    card.cardType match
      case CardType.Jack => 3
      case CardType.Queen => 2
      case CardType.King => 1
      case _ => 0
// This is the only place in the code where the type of an object is explicitly checked. In 
// all other cases polymorphism is used. In this instance it's ok to explicitly check type
// as the choice of CardToValueMap to use is itself chosen polymorphically and within the
// context of Spider was simply have to state the detail that a Jack has value 1.
