
object EnumerationDemo extends Enumeration{
  val red, green, blue, pink = Value

  val black = Value   // 上面一条语句是简写
  val white = Value
  val gray = Value

  val yellow = Value(12, "huang")    //可以随意指定id和名称，但是避免重复
//  上面的代码为实现枚举类型的具体代码，如果不指定id和name，系统默认是id从0开始，name就是变量的名称，可以指定其中的
//  任何一个或者是两个全部指定，已经指定的就按指定的初始化，并且后面的依次递增。
  val purple = Value("zi")          //id为13
  val orange = Value(20)
}
