
import org.scalatest.funsuite.AnyFunSuite

class DeckSuite extends AnyFunSuite {
  test("Deck is initialised ok") {
    val deck = Deck()
    val expected = "Ten, Eight, Queen, Four, Nine, King, Two, Ace, Five, Jack, Seven, Six, Three"
    assert(deck.size === CardType.values.size)
    assert(deck.toString === expected)
  }

  test("Dealing from the deck works correctly") {
    val deck = Deck()
    // Deal first card
    var card = deck.dealCard()
    var expected = "Eight, Queen, Four, Nine, King, Two, Ace, Five, Jack, Seven, Six, Three"
    assert(card.cardType === CardType.Ten)
    assert(deck.size === CardType.values.size - 1)
    assert(deck.toString === expected)

    // Deal second card
    card = deck.dealCard()
    expected = "Queen, Four, Nine, King, Two, Ace, Five, Jack, Seven, Six, Three"
    assert(card.cardType === CardType.Eight)
    assert(deck.size === CardType.values.size - 2)
    assert(deck.toString === expected)

    for i <- 1 to 9 do  // skip to second last card
      deck.dealCard()

    // deal second last card in deck
    card = deck.dealCard()
    expected = "Three"
    assert(card.cardType === CardType.Six)
    assert(deck.size === 1)
    assert(deck.toString === expected)

    // deal last card in deck
    card = deck.dealCard()
    expected = ""
    assert(card.cardType === CardType.Three)
    assert(deck.size === 0)
    assert(deck.toString === expected)
  }

  test("Deck reshuffles correctly") {
    val deck = Deck()
    deck.shuffle()
    val expected = "Nine, Two, Seven, Five, Queen, King, Four, Eight, Six, Three, Ten, Ace, Jack"
    assert(deck.size === CardType.values.size)
    assert(deck.toString === expected)
  }

  test("Deck initialises ok with different seed") {
    val deck = Deck(736586)
    val expected = "King, Five, Seven, Jack, Four, Queen, Two, Three, Six, Nine, Ten, Eight, Ace"
    assert(deck.size === CardType.values.size)
    assert(deck.toString === expected)
  }
}
