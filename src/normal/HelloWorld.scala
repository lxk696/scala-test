import scala.util.Random
import scala.util.control.Breaks._

object HelloWorld extends App {
  println(" app main hello world !" + args.length)

  var b = for {a <- List(1, 2, 3, 4) if a % 2 == 0} yield a
  println(b)


  var increase = (x: Int) => x + 1
  println(increase(10))

  var increase2 = List(1, 2, 3, 4).filter(_ % 2 == 0) //List(1,2,3,4).filter(x => x% 2==0)
  println(increase2)
  println("----1---------------------")
  println(timeFlies())
  println("-----2--------------------")
  var count = 1;
  var fag = true;
  oncePerSecond(timeFlies)


  def oncePerSecond(callback: () => Int) {
    breakable {
      while (fag) {
        if (count >= 3) {
          break;
          //continue;
          //  fag = false
        }
        print("count:" + count + "___");
        println(callback());
        count = count + 1
        Thread sleep 1000
      }
    }
  }

  def timeFlies():Int= {
    println("time flies like an arrow...")
    Random.nextInt(100)
  }

  println("------3-------------------")
  count = 1;
  fag = true;
  oncePerSecond(() => {
                println("time flies like an arrow...");
               Random.nextInt(100) ;}
     )
  println("----4---------------------")
  TestScalaCallJava.main(null);
  new TestScalaCallJava().say("this is scala!!");
}
