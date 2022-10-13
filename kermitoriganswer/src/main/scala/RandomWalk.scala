import scala.collection.mutable.ArrayBuffer

class RandomWalk():
  val update: Path = Path()
  var die: Die = Die()
  def start(dimension: Int) =
    val coorX:Int = 0
    val coorY:Int = 0
    
    var currentLocation = new Array[Int](2)

    var allCellsFilled: Boolean = false
    val grid: Grid = Grid(dimension)


    currentLocation(0) = coorX
    currentLocation(1) = coorY
    
    if(dimension==0)
      println("\nThis is not valid dimension, please input 1 to 100 ;)")
      allCellsFilled = true
    if(dimension==1)
      allCellsFilled = true
      
    while !allCellsFilled do
      currentLocation = die.roll(currentLocation, dimension)
      var cell: Cell = Cell(currentLocation(0), currentLocation(1))
      update.addCell(cell)
      allCellsFilled = grid.checkBoard(currentLocation(0), currentLocation(1))


  def path: Path = update

  def noOfHops:Int =
    update.cellsOnPath.size
  def noOfRolls:Int =
    die.countRolls
