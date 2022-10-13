import scala.collection.mutable.ArrayBuffer

class Path :
  val cellsOnPath = new ArrayBuffer[Cell]()
  def addCell(cell: Cell): ArrayBuffer[Cell]=
    cellsOnPath.addOne(cell)
    cellsOnPath
  def length: Int =
      cellsOnPath.length
  override def equals(other: Any): Boolean =
    other match
      case other: Path =>
        if cellsOnPath.length != other.length then
          return false
        for i <- 0 until cellsOnPath.length do
          if !(cellsOnPath(i) == other.cellsOnPath(i)) then
            return false
        true
      case _ => false
    

