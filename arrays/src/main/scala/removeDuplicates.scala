import scala.collection.mutable.{
  Map,
  HashMap
}
class removeDuplicate:
  def calculate(nums: Array[Int]): Int =
    //removeDuplicates_1(nums)//方法一
    removeDuplicates_2(nums)//方法二


object removeDuplicate
/* 方法一
如果当前element与前一个element不同, 那么直接把前一个element赋值在数组的reassign index上
  如果当前element是数组的最后一个element, 直接把store里面存的element赋值在数组的reassign index上
如果数组里面只有一个element，直接返回1就行*/
//  def removeDuplicates_1(nums: Array[Int]): Int =
//    var store = nums(0)//store存的是上一个重复的element, 不管重复一次或者重复零次
//    //var countSameNumber = 0
//    var reassignAt = 0
//    var countLength = 0
//    for i<-1 until nums.length do
//      if(nums(i)!=store)
//        //countSameNumber = nums.count(z => {z==store})
//        //score += countSameNumber -> store
//        nums(reassignAt) = store
//        reassignAt += 1
//        countLength += 1
//        store = nums(i)
//      if(i==nums.length-1)
//        nums(reassignAt) = store
//        countLength += 1
//    if(nums.length==1)
//      countLength = 1
//    countLength

/*双指针解法:
fast代表第一个指针(指向每次遍历的element), slow代表第二个指针(指向需要重新被assign的那个位置):
使用循环, 当nums(fast) != nums(fast-1), 说明遇到了前后不一样的element, 把fast赋值给slow,
直到最后一个element, slow的个数就是最终返回的长度*/
  def removeDuplicates_2(nums: Array[Int]): Int =
    var slow: Int = 1
    if (nums.length==0)
      slow = 0
    else if (nums.length==1)
      slow = 1
    else
      for i<- 1 until nums.length do
        if(nums(i) != nums(i-1))
          nums(slow) = nums(i)
          slow += 1
    for i<-nums do
      print(s"$i ")
    slow

