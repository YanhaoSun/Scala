
// Represent a Frog in random walk simulation

class Frog(grid: Grid, die: Die, startCell: Cell):
  private var _noOfHops = 0
  private var _currentCell = startCell

  // Hop to new location inside grid
  def hop =
    var newCell = grid.computeNewCell(currentCell, direction = die.roll)
    while grid.outsideBoundary(newCell) do
      newCell = grid.computeNewCell(currentCell, direction = die.roll)
    _currentCell = newCell
    grid.setCellToVisited(currentCell)
    _noOfHops += 1

  def currentCell = _currentCell

  def noOfHops = _noOfHops

