object TestExtends extends App {

  class animal {
    val range = 10;
    val env: Array[Int] = Array[Int] {
      range
    };

    val env2: Array[Int] = new Array[Int](range);
  }

//  class ant extends{
//    override val range: Int = 2;
//  }with animal {
//
//  }
class ant extends animal {
    override val range: Int = 2;
}


  private val ant = new ant()

  println(ant.env.toBuffer)
  println(ant.range)
  //11111
  // 如果ant 不重写 range 则 输出
  //  ArrayBuffer(10)
  //  10

  //22222
  // 如果ant 重写了 range 则 输出
  // ArrayBuffer(0)
  //   2
// TODO 解释 http://www.dataguru.cn/forum.php?mod=viewthread&tid=284847
//  我们现在面临一个问题：range值在超类的构造器中用到了，而超类的构造器先于子类的构造器运行。确切地说，事情发生的过程是这样的：
//  1.Ant的构造器在做它自己的构造之前，调用animal的构造器。
//  2.animal的构造器将它的range字段设为10。
//  3.animal的构造器为了初始化env数组，调用range()取值器。
//  4.该方法被重写以输出（还未初始化的）Ant类的range字段值。
//  5.range方法返回0。（这是对象被分配空间时所有整型字段的初始值。）
//  6.env被设为长度为0的数组。
//  7.Ant构造器继续执行，将其range宁段设为2。

  //33333   解决方案
  // 如果  extends{  override val range: Int = 2; }with animal   采用提前定义，相当于使用特质来避免
  // ArrayBuffer(2)
  //  2

}
