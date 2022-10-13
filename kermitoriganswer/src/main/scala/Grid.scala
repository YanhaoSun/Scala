class Grid(dimension: Int):
  var grid = Array.ofDim[String](dimension, dimension)
  var score: Map[String, String] = Map()
  def checkBoard(x: Int, y: Int):Boolean =
    grid(x)(y) = x.toString+','+y.toString
    score += grid(x)(y) -> "occupied"
    if(score.count(z => true)==(dimension*dimension))
      true
    else
      false
