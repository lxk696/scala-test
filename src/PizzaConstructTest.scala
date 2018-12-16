class PizzaConstructTest(var crustSize: Int, var crustType: String) {
/*  Scala中定义主构造函数使用this关键字：
  每一个辅助构造函数都需要调用之前定义的任何一个构造函数
  每一个辅助构造函数都要有不同的参数表
  一个构造函数使用this关键字调用另一个构造函数
  */

  def this(crustSize: Int) {
    this(crustSize, PizzaConstructTest.DEFAULT_CRUST_TYPE1)
  }

  def this(crustType: String) {
    this(PizzaConstructTest.DEFAULT_CRUST_SIZE, crustType)
  }

  def this() {
    this(PizzaConstructTest.DEFAULT_CRUST_SIZE, PizzaConstructTest.DEFAULT_CRUST_TYPE1)
  }

  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}

object PizzaConstructTest {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE1 = "THIN"
  val DEFAULT_CRUST_TYPE2 = "BOLD"

  def main(args: Array[String]): Unit = {
    //使用主构造函数
   val p1 = new PizzaConstructTest(PizzaConstructTest.DEFAULT_CRUST_SIZE, PizzaConstructTest.DEFAULT_CRUST_TYPE2)//A 12 inch pizza with a THIN crust
    println(p1)
    //使用辅助构造函数
    val p2 = new PizzaConstructTest(PizzaConstructTest.DEFAULT_CRUST_SIZE)// A 12 inch pizza with a THIN crust
    println(p2)
    val p3 = new PizzaConstructTest(PizzaConstructTest.DEFAULT_CRUST_TYPE2)//A 12 inch pizza with a THIN crust
    println(p3)
    val p4 = new PizzaConstructTest()// A 12 inch pizza with a THIN crust
    println(p4)
  }
}

// Exiting paste mode, now interpreting.
//defined class Pizza
//defined object Pizza