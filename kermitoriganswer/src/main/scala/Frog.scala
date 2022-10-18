import java.util
import scala.collection.mutable.ArrayBuffer

class Frog(grid: Grid, die: Die, cell: Cell):
  private var _currentCell = cell
  private var _numOfHops = 0
  def hop =
    var newCell = grid.computeNewCell(currentCell, direction = die.roll)
//    println(s"newCell = $newCell")
    while grid.outsideOfBoundary(newCell) do
      newCell = grid.computeNewCell(currentCell, direction = die.roll)
    _currentCell = newCell
    _numOfHops += 1

  def currentCell: Cell = _currentCell
  def numOfHops = _numOfHops