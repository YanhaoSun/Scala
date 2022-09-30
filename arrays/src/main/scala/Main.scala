import scala.collection.mutable.ArrayBuffer

@main def hello: Unit =
  //for twoSum
  val first = Solution()
  val returnedArray = first.calculate(Array(2, 7, 11, 15), 9)
  println(returnedArray(0)+" : "+returnedArray(1))

  //for removeDuplicates
  val second = removeDuplicate()
  val count = second.calculate(Array(1, 1, 2))
  print(s"Length = $count")
