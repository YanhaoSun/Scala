class plusOne {
//  plusOne.plusOne_1st(Array(1, 2, 3))
  plusOne.plusOne_2nd(Array(1, 2, 3))

}
object plusOne {
  /*思路

  当我们对数组 digits 加一时，我们只需要关注 digits 的末尾出现了多少个9 即可。
  我们可以考虑如下的三种情况：
  *如果digits 的末尾没有 9，例如 [1, 2, 3]，那么我们直接将末尾的数一，得到 [1, 2, 4] 并返回；
  *如果digits 的末尾有若干个9，例如 [1, 2, 3, 9, 9]，那么我们只需要找出从末尾开始的第一个不为9 的元素，
   即3，将该元素加一，得到 [1, 2, 4, 9, 9]。随后将末尾的9 全部置零，得到 [1, 2, 4, 0, 0]并返回。
  *如果digits 的所有元素都是9，例如 [9, 9, 9, 9, 9]，那么答案为 [1, 0, 0, 0, 0, 0]。
   我们只需要构造一个长度比digits 多1 的新数组，将首元素置为1，其余元素置为0 即可。

  算法

  们只需要对数组digits 进行一次逆序遍历，找出第一个不为9 的元素，将其加一并将后续所有元素置零即可。
  如果digits 中所有的元素均为9，那么对应着「思路」部分的第三种情况，我们需要返回一个新的数组。*/
  def plusOne_1st(digits: Array[Int]): Array[Int] = {
    var index = digits.length-1
    var quit: Boolean = false
    while !quit do
      if(digits(index)!=9)
        digits(index) += 1
        quit = true
      else
        digits(index) = 0
        index -= 1
        if(index<0)
          quit = true
    if(index<0)
      var newDigit = new Array[Int](digits.length+1)
      newDigit(0) = 1
      newDigit
    else
      digits
  }
/*
  不用纠结某一位是不是9，而应该去判断加1之后是不是0：
*/
  def plusOne_2nd(digits: Array[Int]): Array[Int] =
    var index = digits.length-1
    var quit: Boolean = false
    while !quit do
      digits(index) = (digits(index)+1)%10
      if(digits(index)!=0)
        quit = true
      index -= 1
      if(index<0)
        quit = true
    println(s"digits(0) = ${digits(0)}")    
    if(index<0 && digits(0)==0)
      var newDigits = new Array[Int](digits.length+1)
      newDigits(0) = 1
      newDigits
    else
      digits
}
