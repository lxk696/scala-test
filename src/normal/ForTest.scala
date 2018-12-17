object ForTest {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3; j <-1 to 3) {
      println(s"i=$i, j=$j, i+j=${i + j}")
    }

//    i=1, j=1, i+j=2
//    i=1, j=2, i+j=3
//    i=1, j=3, i+j=4
//    i=2, j=1, i+j=3
//    i=2, j=2, i+j=4
//    i=2, j=3, i+j=5
//    i=3, j=1, i+j=4
//    i=3, j=2, i+j=5
//    i=3, j=3, i+j=6
  }
}
