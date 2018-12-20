package hard

object TestSington单例 extends App {

  /**
    * * scala中关于单例的模拟
    * * object中的属性和方法都可以当做类似java中的静态成员，都可以通过
    * * object.成员来进行调用
    **/
  object SingletonOps {
    def main(args: Array[String]): Unit = {
      val singleton1 = Singleton.getInstance
      val singleton2 = Singleton.getInstance
      println(singleton1 == singleton2)
      singleton1.index = 5
      println("singleton1.index： " + singleton1.index)
      println("singleton2.index： " + singleton2.index)
    }
  }

  object Singleton {
    private val singleton = Singleton;

    def getInstance = singleton

    var index = 1
  }

  println("-------------------1-----------------------------")

  class Worker private(it: Int) {
    //(it:Int)
    def works() = println("I am the only worker!")
  }

  object Worker {
    //    由于object的构造器只会在第一次调用的时候初始化一次，所以只能产生一个类的对象，故而是单例模式的形式。
    //    但是存不存在java中考虑过的线程安全的问题，有没有可能造成两个程序同时访问一个object导致产生两个对象
    //    synchronized(TestSington单例){}


    def GetWorkInstance(): Worker = {
      TestSington单例.synchronized {
        val worker = new Worker(1)
        worker.works()
        worker
      }
    }


  }

  //  object Job{
  //    def main(args: Array[String]) {
  for (i <- 1 to 5) {
    Worker.GetWorkInstance();
  }
  //    }
  //  }
}
