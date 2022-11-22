
import org.scalatest.funsuite.AnyFunSuite


class LiarGameTest extends AnyFunSuite {
  val deck = Deck()

  test("Game 1 of Liar plays out ok") {
    val game = LiarGame(deck)
    game.play()
    val result = game.result
    assert(result._1 === 4)
    assert(result._2 === 8)
    assert(game.hand1.toString === "Ten, Queen, Nine, Two")
    assert(game.hand2.toString === "Eight, Four, King, Ace")
  }

  test("Game 2 of Liar plays out ok") {
    deck.shuffle()
    val game = LiarGame(deck)
    game.play()
    val result = game.result
    assert(result._1 === 6)
    assert(result._2 === 7)
    assert(game.hand1.toString === "Nine, Seven, Queen, Four")
    assert(game.hand2.toString === "Two, Five, King, Eight")
  }
}
