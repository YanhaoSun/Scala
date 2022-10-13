import scala.util.Random

class Die:
  val ran = new Random(8475136)
  var countRolls: Int = 0

  def generateNextMove(direction: Int, currentLocation: Array[Int]): Array[Int] =
    var X = currentLocation(0)
    var Y = currentLocation(1)
    var directionToString: String = ""
    direction match
      case 0 => directionToString = "North"
      case 1 => directionToString = "South"
      case 2 => directionToString = "East"
      case _ => directionToString = "West"
    
    var storeCoordinate: Array[Int] = new Array[Int](2)
    if (directionToString.equals("North"))
      Y += 1
      storeCoordinate(0) = X
      storeCoordinate(1) = Y
    if (directionToString.equals("South"))
      Y -= 1
      storeCoordinate(0) = X
      storeCoordinate(1) = Y
    if (directionToString.equals("East"))
      X += 1
      storeCoordinate(0) = X
      storeCoordinate(1) = Y
    if (directionToString.equals("West"))
      X -= 1
      storeCoordinate(0) = X
      storeCoordinate(1) = Y
    storeCoordinate


  def roll(currentLocation: Array[Int], dimension: Int): Array[Int] =
    var answer: Boolean = false
    var direction: Int = 0
    var generatedLocation = Array[Int](2)
    while !answer do
      countRolls += 1
      direction = ran.nextInt(4)
      generatedLocation = generateNextMove(direction, currentLocation)
      if((generatedLocation(0)>=0 && generatedLocation(0)<=dimension-1) && (generatedLocation(1)>=0 && generatedLocation(1)<=dimension-1))
        answer = true
    generatedLocation
