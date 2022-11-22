
import scala.collection.mutable.ArrayBuffer

enum CardType:
  case Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King

class Card(val cardType: CardType):
  var value: Int = 0 // set when added to a hand. EXERCISE: try using an Option here.

  override def equals(other: Any): Boolean =
    other match
      case other: Card => cardType == other.cardType
      case _ => false

  def < (other: Card) = value < other.value

  override def toString: String = cardType.toString
