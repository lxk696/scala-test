object AnonymousTest {
  def main(args: Array[String]): Unit = {
    //=>这个符号用在scala中定义匿名函数。


    //例子1：
    var increate = (x: Int) => x + 1
    println(increate(2))
    println("--1----------")

    //例子2：
    val testList = List(1, 2, 3, 4, 5)
    testList.foreach((x: Int) => println(x))
    println("--2----------")


    //例子3：List的filter方法，用来过滤信息，留下要的：
    println(testList.filter((x: Int) => x > 3))
    println("--3----------")

    // 例子4：
    val b = (x: Int) => (y: Int) => x + y
    println(b(1)(2))
    println("--4----------")


    //例子5：
    val b2: (Int, Int) => Int = (x, y) => x + y
    println(b2(1, 2))
    println("--5----------")

  }
}
