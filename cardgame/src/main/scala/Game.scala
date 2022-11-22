import scala.collection.mutable.ArrayBuffer

abstract class Game :
  def play():Unit
  def result:(Int, Int)

class IdiotGame(deck: Deck) extends Game:
  val hand1: IdiotHand = IdiotHand()
  val hand2: IdiotHand = IdiotHand()
  def play(): Unit =
    while(!hand1.isComplete && !hand2.isComplete) do
      hand1.addCard(deck.dealCard())
      hand2.addCard(deck.dealCard())
  def result:(Int, Int) =
    (hand1.value, hand2.value)

class LiarGame(deck: Deck) extends Game:
  val hand1: LiarHand = LiarHand()
  val hand2: LiarHand = LiarHand()
  def play(): Unit =
    while(!hand1.isComplete && !hand2.isComplete) do
      hand1.addCard(deck.dealCard())
      hand2.addCard(deck.dealCard())
  def result:(Int, Int) =
    (hand1.value, hand2.value)

class SpiderGame(deck: Deck) extends Game:
  val hand1: SpiderHand = SpiderHand()
  val hand2: SpiderHand = SpiderHand()
  def play(): Unit =
    while(!hand1.isComplete && !hand2.isComplete) do
      hand1.addCard(deck.dealCard())
      hand2.addCard(deck.dealCard())
  def result:(Int, Int) =
    (hand1.value, hand2.value)