import scala.collection.mutable.ArrayBuffer

class Cell(x: Int, y: Int):
  var coorX: Int = x
  var coorY: Int = y
  override def toString(): String=
    "("+coorX+", "+coorY+")"

  override def equals(other: Any): Boolean =
    other match
      case other: Cell =>
        if coorX != other.coorX then
          false
        else if coorY != other.coorY then
          false
        else
          true


