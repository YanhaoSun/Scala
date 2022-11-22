
import org.scalatest.funsuite.AnyFunSuite


class IdiotGameTest extends AnyFunSuite {
  val deck = Deck()

  test("Game 1 of Idisbot plays out ok") {
    val game = IdiotGame(deck)
    game.play()
    val result = game.result
    assert(result._1 === 38)
    assert(result._2 === 37)
    assert(game.hand1.toString === "Ten, Queen, Nine, Two, Five")
    assert(game.hand2.toString === "Eight, Four, King, Ace, Jack")
  }

  test("Game 2 of Idiot plays out ok") {
    deck.shuffle()
    val game = IdiotGame(deck)
    game.play()
    val result = game.result
    assert(result._1 === 38)
    assert(result._2 === 31)
    assert(game.hand1.toString === "Nine, Seven, Queen, Four, Six")
    assert(game.hand2.toString === "Two, Five, King, Eight, Three")
  }
}