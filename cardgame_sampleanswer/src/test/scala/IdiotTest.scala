
import org.scalatest.funsuite.AnyFunSuite

class IdiotSuite extends AnyFunSuite {
  test("hand with too few cards has zero value") {
    val hand = IdiotHand()
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Ace))
    val handValue = hand.value
    assert(handValue == 0)
  }

  test("regular hand has correct value") {
    val hand = IdiotHand()
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Jack))
    hand.addCard(Card(CardType.King))
    hand.addCard(Card(CardType.Five))
    hand.addCard(Card(CardType.Eight))
    hand.addCard(Card(CardType.Eight))
    val handValue = hand.value
    assert(handValue == 38)
  }

  test("toString produces correct value") {
    val hand = IdiotHand()
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Jack))
    hand.addCard(Card(CardType.King))
    hand.addCard(Card(CardType.Five))
    hand.addCard(Card(CardType.Eight))
    val expected = "Ace, Jack, King, Five, Eight"
    assert(hand.toString == expected)
  }

  test("Additional cards cannot be added to a hand") {
    val hand = IdiotHand()
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Jack))
    hand.addCard(Card(CardType.King))
    hand.addCard(Card(CardType.Five))
    hand.addCard(Card(CardType.Eight))
    hand.addCard(Card(CardType.Nine)) // Additional card -- will be ignored
    val handValue = hand.value
    assert(handValue == 38)
  }

  test("Duplicate cards cannot be added to a hand") {
    val hand = IdiotHand()
    hand.addCard(Card(CardType.Ace))
    hand.addCard(Card(CardType.Ace)) // Duplicate card -- will be ignored
    hand.addCard(Card(CardType.Jack))
    hand.addCard(Card(CardType.King))
    hand.addCard(Card(CardType.Five))
    hand.addCard(Card(CardType.Jack)) // Duplicate card -- will be ignored
    hand.addCard(Card(CardType.Eight))
    hand.addCard(Card(CardType.Eight)) // Duplicate card -- will be ignored
    val handValue = hand.value
    assert(handValue == 38)
  }
}
