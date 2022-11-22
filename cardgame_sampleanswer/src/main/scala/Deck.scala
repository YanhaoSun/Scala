import scala.collection.mutable.ListBuffer
import scala.util.Random

class Deck(rngSeed: Int = 8475136):
  private val rng = Random(rngSeed)
  private val cards = ListBuffer[Card]()
  shuffle()  // so we shuffle the cards as part of construction

  def shuffle() =
    cards.clear() // slight niggle: when called the first time there is no need to clear
    while !deckComplete do
      addNewCard()

  // The bodyless while ... do may look odd here. It's effectively a post-test loop
  // (i.e. a do ... while). Convince yourself of this.
  private def addNewCard() =
    var card: Card = null
    while
      card = Card(CardType.fromOrdinal(rng.nextInt(Deck.fullDeckSize)))
      cards.contains(card)
    do ()
    cards += card // Could card be null? EXERCISE: use an Option to handle this situation.

  def dealCard(): Card = cards.remove(0)

  // toString is a clone of toString in Hand. EXERCISE: how could they share this code?
  override def toString: String =
    cards.size match
      case 0 =>  ""
      case _ => cards.init.foldLeft("")(_  + _.toString + ", ") + cards.last.toString

  private def deckComplete = cards.size == Deck.fullDeckSize

  def size = cards.size

// fullDeckSize is defined to be the number of different types of Card (13).
object Deck:
  val fullDeckSize = CardType.values.length
  