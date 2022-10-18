import scala.util.Random

enum Direction:
  case North, South, East, West

val numOfSides = Direction.values.length
class Die:
  val ran = new Random(8475136)
  private var _countRolls = 0
  def roll: Direction =
    _countRolls += 1
    Direction.fromOrdinal(ran.nextInt(numOfSides))
  def countRolls:Int = _countRolls
  