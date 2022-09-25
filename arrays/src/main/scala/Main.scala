import scala.collection.mutable.ArrayBuffer

@main def hello: Unit =
  val nums = new Array[Int](4)
  nums(0) = 2
  nums(1) = 7
  nums(2) = 11
  nums(3) = 15
  val first = Solution()
  val returnedArray = first.calculate(Array(2, 7, 11, 15), 9)
  println(returnedArray(0)+" : "+returnedArray(1))
//def msg = "I was compiled by Scala 3. :)"
//(nums: Array[Int], target: Int)