
import scala.Int;
import scala.Unit;
import org.omg.Dynamic.Parameter;

/**
  * Created by zhuhailong-dc on 2017/3/3.
  *
  * Scala与Java的区别
  * 1.在Scala中声明private变量,Scala编译器会自动生成get,set方法
  * 2.在Scala中变量需要初始化
  * 3.在Scala中没有静态修饰符,在object下的成员全部都是静态的,如果在类中声明了与该类相同的名字的object则该object是该类的"伴生对象"
  * 可以理解为Scala把类中的static集中放到了object对象中,伴生对象和类文件必须是同一个源文件,可以用伴生对象做一些初始化操作.
  * 4.在Java中可以通过interface实现多继承,在Scala中可以通过特征(trait)实现多重继承,但是与Java不同的是,它可以定义自己的属性和实现方法体
  * 5.object不能提供构造器参数,也就是说object必须是无参的
  *
  * Scala中object与class的区别
  * 在Scala中,类名可以和对象名为同一个名字,该对象称为该类的伴生对象,类和伴生对象可以相互访问他们的私有属性,但是它们必须在同一个源文件中
  * 类只会被编译,不能直接执行,类的声明和主构造器在一起被声明,在一个类中,主构造器只有一个.
  * 类和它的伴生对象可以相互访问其私有成员
  *
  * class和object的一个差别是,单例对象不带参数,而类可以.因为你不能用new关键字实例化一个单例对象,你没有机会传递给它参数
  * 每个单例对象都被作为由一个静态变量指向的虚构类.
  * 特别要指出的是,单例对象会在第一次被访问的时候初始化
  *
  * 不与伴生类共享名称的单例对象被称为孤立对象:standalone object
  */
object ScalaWithObject {
  //private[this] 加上后没有run方法执行按钮

  def main(args: Array[String]): Unit = {
    println(calculate("11"));
    println(calculate("abc"));
    println(cache)
  }

  private var cache = Map[String, Int]()

  def calculate(s: String): Int = {
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ScalaWithObject(100);
      acc.sum = 1
      for (c <- s) {
        println(c)
        acc.add(c.toByte)
      }
      val cs = acc.get()
      cache += (s -> cs)
      cs

    }
  }
}

class ScalaWithObject (val a:Int){
//  def ScalaWithObject(){
//  }
//  def ScalaWithObject(a:Int){
//    this.sum = a;
//  }


  //public 是scala的缺省访问级别
  private var sum: Int = 0;

  //b为val类型,不能再add方法中再次赋值
  def add(b: Int): Unit = {
    sum += b
  }

  def get(): Int = {
    return sum;
  }

  override def toString = s"ScalaWithObject($sum, $get)"


   def canEqual(other: Any): Boolean = other.isInstanceOf[ScalaWithObject]

  override def equals(other: Any): Boolean = other match {
    case that: ScalaWithObject =>
      (that canEqual this) &&
        sum == that.sum
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(sum)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
