class PizzaConstructTest(var crustSize: Int, var crustType: String) {
/*  Scala中定义主构造函数使用this关键字：
  每一个辅助构造函数都需要调用之前定义的任何一个构造函数
  每一个辅助构造函数都要有不同的参数表
  一个构造函数使用this关键字调用另一个构造函数
  */
  var DEFAULT_CRUST_TYPE1="123";

  // one-arg auxiliary constructor
  def this(crustSize: Int) {
    this(crustSize, PizzaConstructTest.DEFAULT_CRUST_TYPE)
  }
  // one-arg auxiliary constructor
  def this(crustType: String) {
    this(PizzaConstructTest.DEFAULT_CRUST_SIZE, crustType)
  }
  // zero-arg auxiliary constructor
  def this() {
    this(PizzaConstructTest.DEFAULT_CRUST_SIZE, PizzaConstructTest.DEFAULT_CRUST_TYPE)
  }

  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}


object PizzaConstructTest {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"

  def main(args: Array[String]): Unit = {
    val p1 = new PizzaConstructTest(PizzaConstructTest.DEFAULT_CRUST_SIZE, PizzaConstructTest.DEFAULT_CRUST_TYPE)
    val p2 = new PizzaConstructTest(PizzaConstructTest.DEFAULT_CRUST_SIZE)
    val p3 = new PizzaConstructTest(PizzaConstructTest.DEFAULT_CRUST_TYPE)
    val p4 = new PizzaConstructTest
    println(p1)
    println(p2)
    println(p3)
    println(p4)
  }
}