
// The Game class represents what all games have in common
abstract class Game(protected val deck: Deck):
  def hand1: Hand // hand1 and hand2 are overridden by vals in the subclasses
  def hand2: Hand // They could be val here too, but def FORCES you to override them

  def play() = // Simple Template Method
    for i <- 1 to hand1.numOfCards do
      hand1.addCard(deck.dealCard())
      hand2.addCard(deck.dealCard())

  def result: (Int, Int) = (hand1.value, hand2.value)

/* Each concrete Game extends Game and defines its own type of Hand. */

class IdiotGame(deck: Deck) extends Game(deck):
  override val hand1 = IdiotHand()
  override val hand2 = IdiotHand()

class LiarGame(deck: Deck) extends Game(deck):
  override val hand1 = LiarHand()
  override val hand2 = LiarHand()

class SpiderGame(deck: Deck) extends Game(deck):
  override val hand1 = SpiderHand()
  override val hand2 = SpiderHand()