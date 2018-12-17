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
