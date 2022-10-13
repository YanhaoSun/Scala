
import scala.annotation.targetName
import scala.collection.mutable.ArrayBuffer

class Path:
  val cellsOnPath = ArrayBuffer[Cell]()

  def addCell(cell: Cell) = cellsOnPath += cell

  def length: Int = cellsOnPath.length

  def apply(i: Int): Cell = cellsOnPath(i)

  override def equals(other: Any): Boolean =
    other match
      case other: Path =>
        if cellsOnPath.length != other.length then
          return false
        var allMatchedSoFar = true // unless found otherwise
        for i <- 0 until cellsOnPath.length do
          if !(cellsOnPath(i) == other(i)) then
            allMatchedSoFar = false
        allMatchedSoFar
      case _ => false

  override def toString: String =
    var str = ""
    for cell <- cellsOnPath.init do
      str += cell.toString + ", "
    str += cellsOnPath.last.toString
    str
