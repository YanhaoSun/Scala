
// A 4-sided die where each side represents a compass direction

import scala.collection.mutable.Map
import scala.util.Random

enum Direction:
  case North, South, East, West

val numOfSides  = Direction.values.length//计数枚举中value的长度
                                         //一共有东南西北四个value, 所以长度为4


class Die:
  val rng =  Random(8475136)
  private var _noOfRolls = 0

  // Return a random Direction
  def roll: Direction =
    _noOfRolls += 1
    Direction.fromOrdinal(rng.nextInt(numOfSides))//numOfSides = 4, nextInt就会产生0-3的值
                                                  //假如说随机数产生了0, 那么Direction.fromOrdinal就会把0对应到enum中的第一个value上

  def noOfRolls: Int = _noOfRolls