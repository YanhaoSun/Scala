import java.util
import scala.collection.mutable.ArrayBuffer

class Frog(dimension: Int):
  var walk: RandomWalk = RandomWalk()
  walk.start(dimension)
  println(s"Total number of hops: ${walk.noOfHops}")
  println(s"Total number of die rolls: ${walk.noOfRolls}")
  
  if(dimension==0 || dimension==1)
    println(s"Path: Empty")
  
  var count = 1
  print(s"Path: ")
  for i<-walk.path.cellsOnPath do
    if(count!=walk.path.cellsOnPath.size)
      print(s"${i.toString()}, ")
    else
      print(s"${i.toString()}")
    count += 1
