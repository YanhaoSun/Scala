import scala.collection.mutable.ArrayBuffer

class RandomWalk():
  val path = Path()
  private val die = Die()
  private var kermit:Frog = null
  def start(dimension: Int) =
    val grid = Grid(dimension)
    kermit = Frog(grid, die, Cell(0, 0))
    while !grid.allCellsVisited do
//      println("enter while loop")
      kermit.hop
      grid.setCellToVisited(kermit.currentCell)
      path.addCell(kermit.currentCell)


  def noOfHops:Int =
    kermit.numOfHops
  def noOfRolls:Int =
    die.countRolls
