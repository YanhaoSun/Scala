
@main def hello(dimension: Int): Unit =
//  Comment: Great work! All tests passing successfully.
//  Enums not used for directions, this would have been much better instead of hardcoding them as strings.
//  Could have used the Cell class more for example "currentLocation" doesn't need to be an Array.
//  Careful with mixing Java syntax like using the "new" keyword.
//  Avoid using ‘return’ — refactor the method to have only one exit point.
//  Add some spacing between your methods for better readability.

  if dimension<0 then
    System.exit(0)
  val first = RandomWalk()
  first.start(dimension)

  println(s"Total number of hops: ${first.noOfHops}")
  println(s"Total number of rolls: ${first.noOfRolls}")
  print(s"Path: ")
  var count=1
  for(i <- first.path.cellsOnPath)
    if count!=first.path.length then
      print(i.toString()+", ")
      count += 1
    else
      println(i.toString())
