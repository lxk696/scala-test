class TestMyScalaListDef[A] {

  //def ::[B >: A](x : B) : scala.collection.immutable.List[B] = { /* compiled code */ }
  // def ::[B >: A](x: B): List[B]
  def ::[B >: A](x: B): scala.collection.immutable.List[B] = {
    scala.collection.immutable.List(x);
  }

}

object TestMyScalaListDef {
  //def apply: TestMyScalaListDef = new TestMyScalaListDef()
  def apply[A]: TestMyScalaListDef[A] = new TestMyScalaListDef[A]()

  def main(args: Array[String]): Unit = {
    val theObj1 = TestMyScalaListDef[String]
    //val theObj1 = TestMyScalaListDef[String]("String test")  //运行报错，编译不报错
    val theObj2 = new TestMyScalaListDef[String]
    println(theObj1 + "————" + theObj2);

    var x = "lxk" :: "123" :: TestMyScalaListDef[String];
    println(x);
    println("---1------------");
    //def ::[B >: A](x : B) : scala.collection.immutable.List[B] = { /* compiled code */ }
    //但是我们使用的时候可以这样：
    val newList = "a" :: "b" :: List() :: Nil //List(a, b, List())
    println(newList)

    //自定义例子：  >>:
    object Log { //class Log 不行！！！ TODO
      def >+>:(data: String) = {
        println(data);
        //Log
      }

      def >>:(data: String): Log.type = {
        println(data);
        Log
      }
    }

    "SCALA" >>: "Spark" >>: "Hadoop" >>: Log
    "[---- test>+>: ---] " >+>: Log

    println("---2------------");
  }
}