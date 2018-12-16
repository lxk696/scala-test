object TestOther extends App {
  var hd = "helloworld"
  println(s"" + hd + s"__\r\n ${hd}" + raw"__\r\n ${hd}" + s"__$hd") //raw 只对 \r\n  等转义字符有效
  hd.foreach(x => printf("%s-", x))
  //hd foreach println
  ///r/n
  println()
  println("----0-------------")


  val f = (_: Int) + (_: Int)
  println(f(2, 3))

  val xMax, yMax = 100
  println(xMax + "__" + yMax)
  println("----1-------------")


  // Array[Int] 参数不行？？
  def sum(inclusive: Range.Inclusive) = inclusive.sum

  val s = sum(1 to 5)
  println(s)

  def sum2(inclusive: Int*) = inclusive.sum

  val s2 = sum2(1 to 5: _*)
  println(s2)

  println(("scala", "spark")._2)
  println("----2-------------")


  println("----3-------------")

  // scala类中不带参数的方法和属性可以互相重写。？？？TODO
  //在 Scala 中当方法不需要接受参数时可定义成两种类型的方法
  // 只有abstract class才能定义 abstract方法
  // 不能重写
  //def width1(): Int ;  //空括号方法(empty-paren method) object
  //def width2: Int  ;   // 无参数方法(parameterless method)

  // 不能重写
  //  def width()=1 ;
  //  def width=1 ;
}

class TestOther {
  // 不能重写
  //  def width()=1 ;
  //  def width=1 ;
}


