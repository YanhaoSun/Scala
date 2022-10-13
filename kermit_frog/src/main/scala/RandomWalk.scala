
class RandomWalk:
  val path = Path()
  private val die = Die()
  private var kermit:Frog = null

  def start(dimension: Int) =
    val grid = Grid(dimension)
    kermit = Frog(grid, die, Cell(0, 0))
    while !grid.allCellsVisited do
      kermit.hop
      path.addCell(kermit.currentCell)
  
  def noOfHops = kermit.noOfHops

  def noOfRolls = die.noOfRolls

