import scala.collection.mutable.ArrayBuffer

abstract class Hand:
  val cardOnHand = new ArrayBuffer[Card]//store cards that have no duplicate
  def addCard(card: Card):Unit =
    var contain: Boolean = false
    for (i <- cardOnHand) do
      if (i.obtainCardType == card.obtainCardType)
        contain = true
    if (!contain && !isComplete)
      cardOnHand += card
      
  def value: Int =
    computeHandValue(cardOnHand)
  override def toString: String =
    var result: String = ""
    var count = 0;
    for (i <- cardOnHand) do
      if (count != 0)
        result += ", " + i.toString
        count += 1
      else
        result += i.toString
        count += 1
    result
  def isComplete: Boolean
  def computeHandValue(cardOnHand: ArrayBuffer[Card]): Int


class IdiotHand extends Hand:
  var valueRulesOfIdiot: CardType => Int =
    (cardType: CardType) => cardType match
      case CardType.Ace => 1
      case CardType.Two => 2
      case CardType.Three => 3
      case CardType.Four => 4
      case CardType.Five => 5
      case CardType.Six => 6
      case CardType.Seven => 7
      case CardType.Eight => 8
      case CardType.Nine => 9
      case CardType.Ten => 10
      case CardType.Jack => 11
      case CardType.Queen => 12
      case _ => 13
//  case Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
  def computeHandValue(cardOnHand: ArrayBuffer[Card]): Int =
    var valueOfHand: Int = 0
    if (isComplete)
      for (i <- cardOnHand) do
        valueOfHand += i.value(valueRulesOfIdiot)
      valueOfHand
    else
      valueOfHand

  def isComplete: Boolean =
    if(cardOnHand.length==5)
      true
    else
      false

class LiarHand extends Hand:
  var valueRulesOfLiar: CardType => Int =
    (cardType: CardType) => cardType match
      case CardType.Ace => 13
      case CardType.Two => 12
      case CardType.Three => 11
      case CardType.Four => 10
      case CardType.Five => 9
      case CardType.Six => 8
      case CardType.Seven => 7
      case CardType.Eight => 6
      case CardType.Nine => 5
      case CardType.Ten => 4
      case CardType.Jack => 3
      case CardType.Queen => 2
      case _ => 1

  def computeHandValue(cardOnHand: ArrayBuffer[Card]): Int =
    var valueOfHand: Int = 0
    var valueOfEachCard: ArrayBuffer[Int] = ArrayBuffer()
    if(isComplete)
      for(i <- cardOnHand) do
        valueOfEachCard += i.value(valueRulesOfLiar)
      var sortedValueOfEachCard = valueOfEachCard.sorted
      valueOfHand = (sortedValueOfEachCard(1)+sortedValueOfEachCard(2))/2
      valueOfHand
    else
      valueOfHand

  def isComplete: Boolean =
    if (cardOnHand.length == 4)
      true
    else
      false



class SpiderHand extends Hand:
  var valueRulesOfSpider: CardType => Int =
    (cardType: CardType) => cardType match
      case CardType.Jack => 3
      case CardType.Queen => 2
      case CardType.King => 1
      case _ => 0

  def computeHandValue(cardOnHand: ArrayBuffer[Card]): Int =
    var valueOfHand: Int = 0
    var valueOfEachCard: ArrayBuffer[Int] = ArrayBuffer()
    if (isComplete)
      for (i <- cardOnHand) do
        valueOfEachCard += i.value(valueRulesOfSpider)
      var sortedValueOfEachCard = valueOfEachCard.sorted
      valueOfHand = sortedValueOfEachCard(0) + sortedValueOfEachCard(2)
      valueOfHand
    else
      valueOfHand

  def isComplete: Boolean =
    if (cardOnHand.length == 3)
      true
    else
      false