/*
题目: 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

示例:

输入: nums = [1,3,5,6], target = 5
输出: 2

输入: nums = [1,3,5,6], target = 2
输出: 1

输入: nums = [1,3,5,6], target = 7
输出: 4


*/
class searchInsert(nums: Array[Int], target: Int):
  searchInsert.searchInserts(nums, target)



object searchInsert:
  def searchInserts(nums: Array[Int], target: Int): Int =
    var half = 0
    var left = 0
    var right = nums.length-1
    println(s"1/2 = ${1/2}")
    var found: Boolean = true
    while found do
      half = left+(right-left)/2
      println(s"half = $half")
      if(nums(half)==target)
        found = false
      else if(target > nums(nums.length-1))
        half = nums.length
        found = false
      else if(target < nums(0))
        half = 0
        found = false
      else if(half!=0 && nums(half-1)<target && target<nums(half))
        found = false
        println(s"Sssssadsdasfasdasdasd")
      else if(nums(half)<target)
        left = half+1
      else if(nums(half)>target)
        right = half-1
    half