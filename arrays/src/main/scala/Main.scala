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
  val forth = searchInsert.searchInserts(Array(1,3), 3)
  println(s"result = $forth")
  println()
  
  //for plusOne
  val fifth_1st = plusOne.plusOne_1st(Array(0))
  for i<-fifth_1st do
    print(s"$i")
  println()  
  val fifth_2nd = plusOne.plusOne_2nd(Array(9))
  for i <- fifth_2nd do
    print(s"$i")
  

