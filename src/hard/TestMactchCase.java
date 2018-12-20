object TestMactchCase  extends  App {
  val x: Int = 10;
 var result = x match {
   case 11 => "zero11"
   case 10 => "one"
   case 21 => "two"
   case _ => "many"
 }
  println(result)


  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  println(matchTest(3)) // many
  println(matchTest(1)) // one





}
