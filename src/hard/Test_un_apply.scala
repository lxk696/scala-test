object Test_un_apply extends App {
//  apply方法有点类似于java中的构造函数，接受构造参数变成一个对象。那么unapply方法就刚好相反，他是接受一个对象，从对象中提取出相应的值。


//  unapply方法主要用于模式匹配中。
//  看个简单的例子：

  class Money(val value: Double, val country: String) {

  }

  object Money {
    def apply(value: Double, country: String) : Money = new Money(value, country)

    def unapply(money: Money): Option[(Double, String)] = {  // TODO 必须为 Option[(Double, String)]  ,和 Money(num, country) 参数对应
      println("unapply money ! val:"+money.value+",country:"+money.country)
      if(money == null) {
        None
      } else {
        Some(money.value, money.country)
        //Some(1111, "$$$")
      }
    }
  }

 // 客户端实现：
  def testUnapply() = {
    val money = Money(10.1, "RMB")
    println("define money! to do unapply 。。。")
    money match {
      case Money(num, "MeiYuan") =>  println("MeiYuan--: " + num)   // 第一次调用unapply ,country 不等于 MeiYuan，走下面的case
      case Money(num, "RMB") =>  println("RMB--: " + num)
      case Money(num, country) =>  println(country+" --: " + num)//匹配样式多，得配套unapply
      case m:Money =>  println(m.country+" --: " +m.value)// 只能匹配种类，用法太少
      case _ => println("Not RMB!")
    }
  }
  testUnapply
//  最后输出为：
// define money! to do unapply 。。。
// unapply money ! val:10.1,country:RMB
// unapply money ! val:10.1,country:RMB
// RMB--: 10.1

}
