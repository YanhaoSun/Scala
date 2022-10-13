
// A 4-sided die where each side represents a compass direction

import scala.collection.mutable.Map
import scala.util.Random

enum Direction:
  case North, South, East, West

val numOfSides  = Direction.values.length

class Die:
  val rng =  Random(8475136)
  private var _noOfRolls = 0

  // Return a random Direction
  def roll: Direction =
    _noOfRolls += 1
    Direction.fromOrdinal(rng.nextInt(numOfSides))

  def noOfRolls: Int = _noOfRolls