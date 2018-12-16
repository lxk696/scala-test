object TestCallByValue_Name extends App {
  def time() = {
    //对于函数返回的基本数据类型，如Int、Long、Double等，编译器能够自动推断出类型，可以不用写返回类型；
    //对于嵌套的类型，自定义类型需要在函数参数列表后加上“:返回类型 = ”的方式带上返回类型。
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  def delayed(t: => Long) = {
    println("在 delayed 方法内")
    println("参数： " + t) //#### 传名调用，调用 time()一次
    t //#### 传名调用，又调用 time()一次
  }

  /*   Scala的解释器在解析函数参数(function arguments)时有两种方式：
    ####传值调用（call-by-value）：先计算参数表达式的值，再应用到函数内部；
    ####传名调用（call-by-name）：将未计算的参数表达式直接应用到函数内部。
    在进入函数内部前，传值调用方式就已经将参数表达式的值计算完毕，而传名调用是在函数内部进行参数表达式的值计算的。
 TODO    #####这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值。和时间等有状态的值时会有异常,消耗额外资源 #######
   */

  // delayed 方法， 该方法在变量名和变量类型后使用 => 符号来设置传名调用
  println("传名调用结果： " + delayed(time())) // 传名调用
  //  在 delayed 方法内
  //####  获取时间，单位为纳秒
  //  参数： 2134000476622
  //###  获取时间，单位为纳秒
  // 传名调用结果： 2134000510266   //#####  2次t 不一样了 TODO

  println("------------------")

  var nanoTime = time
  println("传值调用结果： " + delayed(nanoTime)) // 传名调用
  //  获取时间，单位为纳秒
  //  在 delayed 方法内
  //  参数： 2468239201204
  //  传值调用结果： 2468239201204    //#####  2次t 一样的  TODO

  println("--1----------------")
  // 方法在调用前后是无所谓的，优先加载方法？调用方法时再去找方法定义?
  println(addInt()) // 不传入参数，两个参数使用默认值
  println(addInt(2)) // 传入参数，参数b使用默认参数
  println(addInt(b = 3)) // 指定传入参数b，参数a使用默认值
  println(addInt(b = 3, a = 11)) // 指定传入参数b,a 的名字， 顺序可以变化
  def addInt(a: Int = 1, b: Int = 2): Int = {
    a + b
  }

  println("--2----------------")


  var inc = (x: Int) => x + 1 //相当于数学中，定义的函数表达式inc = f(x) = x + 1
  //上述定义的匿名函数，其实是下面这种写法的简写：
  def inc2 = new Function[Int, Int] {//Function
    def apply(x: Int): Int = x + 1;
  }

  def inc3: Int => Int = new Function1[Int, Int] {//Function1
    def apply(x: Int): Int = x + 1;
  }

  def inc4: Int => Int = new ((Int) => Int) {
    def apply(x: Int): Int = x + 1;
  }


  def inc5(x: Int): Int = x + 1;
  // 4  4  4  4  4
  println(inc(3))
  println(inc2(3))
  println(inc3(3))
  println(inc4(3))
  println(inc5(3))



  var userDir = () => { System.getProperty("user.dir") }

}
