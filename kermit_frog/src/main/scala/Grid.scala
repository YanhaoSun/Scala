
enum CellState:
  case Visited
  case Unvisited

// A square grid
class Grid(dimension: Int, startCell: Cell = Cell(0, 0)):
  val lowerLeft = Cell(0, 0)
  val upperRight = Cell(dimension - 1, dimension - 1)
  val grid = Array.ofDim[CellState](dimension, dimension)
  for(i <- 0 until dimension; j <- 0 until dimension)
    grid(i)(j) = CellState.Unvisited
  setCellToVisited(startCell)
  
  // Return true iff the given cell lies outside the grid
  def outsideBoundary(cell: Cell): Boolean =
    (cell.x < lowerLeft.x || cell.x > upperRight.x) ||
    (cell.y < lowerLeft.y || cell.y > upperRight.y)
  
  // Return cell in given direction
  def computeNewCell(cell: Cell, direction: Direction): Cell =
    direction match 
      case Direction.North => Cell(cell.x, cell.y+1)
      case Direction.South => Cell(cell.x, cell.y-1)
      case Direction.East =>  Cell(cell.x+1, cell.y)
      case Direction.West =>  Cell(cell.x-1, cell.y)

  def setCellToVisited(cell: Cell): Unit =
    grid(cell.x)(cell.y) = CellState.Visited

  def allCellsVisited: Boolean =
    var allVisited = true // unless unvisited cell found
    for (i <- 0 until dimension; j <- 0 until dimension)
      if grid(i)(j) == CellState.Unvisited then
        allVisited = false
    allVisited
    
