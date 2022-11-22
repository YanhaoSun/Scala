
import scala.collection.mutable.ListBuffer

// Abstract class Hand represents what all hands have in common
abstract class Hand(val numOfCards: Int):
  protected val cards = ListBuffer[Card]()
  def cardToValueMapping: CardToValueMap // Deferred Method

  // Template Method, calls the cardToValueMapping deferred method to
  // calculate the value of the card
  def addCard(card: Card) =
    if cards.length < numOfCards && !cards.contains(card) then
      card.value = cardToValueMapping.value(card)
      cards += card

  def value: Int // Deferred Method

  // toString is a clone of toString in Deck. EXERCISE: how could they share this code?
  override def toString =
    cards.size match
      case 0 => ""
      case _ => cards.init.foldLeft("")(_ + _.toString + ", ") + cards.last.toString

/* Now each concrete Hand subclass needs only to tell its superclass how many cards
   in a hand, and provide an implementation of the  cardToValueMapping method. */

class IdiotHand extends Hand(IdiotHand.numOfCards):
  override def cardToValueMapping = IdiotCardValues

  def value: Int =1
    if cards.length < numOfCards then 0
    else cards.foldLeft(0)(_ + _.value)

// Companion object for the IdiotHand class. Could have stored the cardToValueMapping
// mapping here as well.
object IdiotHand:
  val numOfCards = 5

class LiarHand extends Hand(LiarHand.numOfCards):
  override def cardToValueMapping = LiarCardValues

  override def value: Int =
    // Nested function. Makes code clearer.
    def median(cards: ListBuffer[Card]) =
      val (lower, upper) = cards.sortWith(_ < _).splitAt(cards.size / 2)
      if (cards.size % 2 == 0) then
        (lower.last.value + upper.head.value) / 2
      else
        upper.head.value
    // With median defined, the body of value is easy to write:
    if cards.length < numOfCards then 0
    else median(cards)

object LiarHand:
  val numOfCards = 4

class SpiderHand extends Hand(SpiderHand.numOfCards):
  override def cardToValueMapping = SpiderCardValues
  
  override def value: Int =
    if cards.length < numOfCards then 0
    else
      val maxValue = cards.foldLeft(0)((bestSoFar: Int, card: Card) => bestSoFar max card.value)
      val minValue = cards.foldLeft(Int.MaxValue)((bestSoFar: Int, card: Card) => bestSoFar min card.value)
      minValue + maxValue

object SpiderHand:
  val numOfCards = 3