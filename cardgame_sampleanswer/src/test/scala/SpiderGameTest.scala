
import org.scalatest.funsuite.AnyFunSuite


class SpiderGameTest extends AnyFunSuite {
  val deck = Deck(996453)

  test("Game 1 of Spider plays out ok") {
    val game = SpiderGame(deck)
    game.play()
    val result = game.result
    assert(result._1 === 0)
    assert(result._2 === 0)
    assert(game.hand1.toString === "Three, Ten, Five")
    assert(game.hand2.toString === "Nine, Seven, Ace")
  }

  test("Game 2 of Spider plays out ok") {
    deck.shuffle()
    val game = SpiderGame(deck)
    game.play()
    val result = game.result
    assert(result._1 === 3)
    assert(result._2 === 2)
    assert(game.hand1.toString === "Three, Jack, Nine")
    assert(game.hand2.toString === "Five, Queen, Ten")
  }
}
