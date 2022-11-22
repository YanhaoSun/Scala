enum CardType:
  case Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
val numOfCards = CardType.values.length

class Card(typeOfCard: CardType):
  override def toString: String =
    typeOfCard.toString

  def value(valueFunc: CardType => Int): Int =
    valueFunc(typeOfCard)
  def obtainCardType: CardType = typeOfCard
