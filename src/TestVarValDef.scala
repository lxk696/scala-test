object TestVarValDef {
  var a1 : Int = _  //a=0
  var a2 : Double = _ //a=0.0
  var a3 : Event[Int] = _ //a=null

//  val a1 : Int = 0  //a=0
//  val a2 : Double = 0 //a=0.0
//  val a3 : Test[Int] = null //a=null

  def main(args: Array[String]): Unit = {
    println(a1)
    println(a2)
    println(a3)

  }
}
