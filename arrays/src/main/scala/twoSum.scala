
import scala.collection.mutable.{
  Map,
  HashMap
}
class Solution:
  def calculate(nums: Array[Int], target: Int): Array[Int] =
    twosum(nums, target: Int)

/*
使用枚举法解决twoSum, time complexity = O(n^2)
                              space complexity = O(1)
*/
//object Solution
//  def twosum(nums: Array[Int], target: Int): Array[Int] =
//    val returned = new Array[Int](2)
//    for i <- nums.indices do
//      var store: Int = target - nums(i)
//      var j: Int = i + 1
//      for (m <- j until nums.length) do
//        if (store == nums(m))
//          returned(0) = i
//          returned(1) = m
//    returned

/*使用hashTable解决twoSum,
timeComplexity = O(n)
spaceComplexity = O(n), n 主要为hashTable的开销*/
object Solution
  def twosum(nums: Array[Int], target: Int): Array[Int] =
    val returned = new Array[Int](2)
    var score: Map[Int, Int] = Map()
    for i <- nums.indices do
        if (score.contains(target-nums(i)))
          returned(0) = score(target-nums(i))
          returned(1) = i
        else
          score += nums(i) -> i
    returned