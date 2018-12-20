/**
  * Scala 偏应用函数
  * Scala 偏应用函数是一种表达式，不必提供函数需要的所有参数，只需要提供部分，或不提供所需参数。
  */
object Test_ToMethod extends App {
  val date = new Date
  val logWithDateBound = log(date, _: String)

  logWithDateBound("message1")
  Thread.sleep(1000)
  logWithDateBound("message2")
  Thread.sleep(1000)
  logWithDateBound("message3")

  def log(date: Date, message: String) = {
    println(date + "----" + message)
  }

}
