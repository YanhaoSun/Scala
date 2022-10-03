//题目: 移除元素
class removeElement:
  def removeElements(nums: Array[Int], `val`: Int): Int =
    var slow = 0
    for (i<-nums.indices) do
      if(nums(i)!=`val`)
        nums(slow) = nums(i)
        slow += 1
    slow



