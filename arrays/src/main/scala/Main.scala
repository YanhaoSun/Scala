import scala.collection.mutable.ArrayBuffer

@main def hello: Unit =
  //for twoSum
  val first = Solution()
  val returnedArray = first.calculate(Array(2, 7, 11, 15), 9)
  println(returnedArray(0)+" : "+returnedArray(1))

  //for removeDuplicates
  val second = removeDuplicate()
  val count = second.calculate(Array(1, 1, 2))
  println(s"Length = $count")

  //for removeElements
  val third = removeElement()
  val returnThird = third.removeElements(Array(0,1,2,2,3,0,4,2), 2)
  println(s"length of third = $returnThird")

  //for searchInsert
  val result = searchInsert.searchInserts(Array(1,3), 3)
  println(s"result = $result")

