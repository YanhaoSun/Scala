

enum cellState:
  case visited
  case unvisited

class Grid(dimension: Int, startCell: Cell = Cell(0, 0)):
  var grid = Array.ofDim[cellState](dimension, dimension)
  val lowerLeft = Cell(0, 0)
  val upperRight = Cell(dimension-1, dimension-1)
  for(i <- 0 until dimension; j <- 0 until dimension)
    grid(i)(j) = cellState.unvisited
  setCellToVisited(startCell)

  def outsideOfBoundary(cell: Cell): Boolean =
    var outside: Boolean = false
    if(cell.coorX<lowerLeft.coorX || cell.coorX>upperRight.coorX) || (cell.coorY<lowerLeft.coorY || cell.coorY>upperRight.coorY) then
      outside = true
//    println(s"outside = $outside")
    outside
  def allCellsVisited: Boolean =
    var visited = true
    for(i <- 0 until dimension; j <- 0 until dimension)
      if(grid(i)(j)==cellState.unvisited)
        visited = false
//    println(s"visited = $visited")
    visited

  def computeNewCell(currentCell: Cell, direction: Direction): Cell =
    direction match
      case Direction.North => Cell(currentCell.coorX, currentCell.coorY+1)
      case Direction.South => Cell(currentCell.coorX, currentCell.coorY-1)
      case Direction.East => Cell(currentCell.coorX+1, currentCell.coorY)
      case Direction.West => Cell(currentCell.coorX-1, currentCell.coorY)
  def setCellToVisited(cell: Cell) =
    grid(cell.coorX)(cell.coorY) = cellState.visited
