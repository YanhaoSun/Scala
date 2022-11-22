object abc:
  def calculate: Unit =
    for
      i<-1 to 3; j <- 5 to 7
      if i% 2 ==0; if j%2==1
    do
      println(s"($i, $j)")
