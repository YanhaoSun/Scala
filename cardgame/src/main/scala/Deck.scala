import java.util
import scala.collection.mutable
import scala.util.Random
import scala.collection.mutable.{ArrayBuffer, LinkedHashMap, ListBuffer}
class Deck(seed: Int = 8475136):
  var storeCards:ArrayBuffer[Card] = ArrayBuffer()
  var ran = Random(seed)
  shuffle()


  def dealCard(): Card =
    var dealed: Card = storeCards.head
    storeCards -= dealed
    dealed


  def shuffle():Unit =
    if(storeCards.nonEmpty)
      storeCards.clear()
    var countCards = 0
    while countCards != 13 do
      var generatedCard = CardType.fromOrdinal(ran.nextInt(numOfCards))
      if (!isContained(generatedCard))
        storeCards += Card(generatedCard)
        countCards += 1


  def isContained(cardType: CardType): Boolean =
    var contain: Boolean = false
    for(i <- storeCards) do
      if(i.obtainCardType==cardType)
        contain = true
    contain


  override def toString:String =
    var result: String = ""
    var count = 0;
    for(card <- storeCards)
      if(count!=0)
        result += ", "+card.obtainCardType
        count += 1
      else
        result += card.obtainCardType
        count+=1
    result
  def size: Int = storeCards.size

