
// A cell in the grid

class Cell(val x:Int, val y:Int):
  override def equals(other: Any): Boolean =
    other match
      case other: Cell => this.x == other.x && this.y == other.y
      case _ => false
  
  override def toString(): String =
    s"(${x}, ${y})"
