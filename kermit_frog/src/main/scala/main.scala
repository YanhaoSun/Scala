import scala.math.*

@main def skippy(dimension: Int): Unit =
  if dimension < 0 then
    System.exit(0)
  val skippySimulation = RandomWalk()
  skippySimulation.start(dimension)
  
  println(s"Total number of hops: ${skippySimulation.noOfHops}")
  println(s"Total number of die rolls: ${skippySimulation.noOfRolls}")
  println(s"Path: ${skippySimulation.path.toString}")












