package hard

object Test_Private_4_this extends App {
//  private[包名],private[this] 可以放在字段，方法和类上，用来限制访问权限；
//  1private[包名]包名可以是父包名或当前包名，如果是父包名，则父包和子包都可以访问
//  2private[this]修饰的方法或字段只能在本类访问，如果是字段编译成java的时候就没有get或set方法。
//
//  3如果有两个名称相同的子包，比如
//  package x.y.z.x.v
//  有两个x，当private[x]的是否离当前包最近的一个包生效
//  4我的困惑是我查看class文件反编译以后的java类，在class上加private[]的信息去哪了，在反编译的文件中找不到，并且删除scala文件，把生成的class文件放到工程中，他的效果依然存在。
  class Person {
    var varName = "Spark"
    private var priName = "GreenPlum"
    private[this] var prithisName = "Oracle"

    def getName() {
      println("Hello 1-" + varName + "," + priName + "," + prithisName)
    }

    def getInsName(p: Person) {
      println("Hello 2-" + p.varName + "," + p.priName+ "," + prithisName)
    }

    // private[this] 类型不看作是类的成员，连自己类的内部方法中都不能访问，定义的时候就报错。
    //def getInsName1(p : Person){println("Hello " + p.prithisName)}
  }


  val p1 = new Person

  val p2 = new Person

  println(p1.varName) //  --默认public允许实例化后访问

//  p1.priName // -- private类型不允许实例化后访问 Symbol priName is inaccessible from this place  但可以在Person类里面访问
//  p1.prithisName //--private[this]类型不看作是类的成员,实例化后无法访问  Symbol prithisName is inaccessible from this place
  p1.getName()
  p1.getInsName(p2)
  //Hello Spark,GreenPlum
  p2.getName()
  p2.varName = "Spark233"
  p2.getName()
  p1.getInsName(p2) //

}
