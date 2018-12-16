/**
  * 基本事件类，继承时间的抽象类
  * @param name 事件名称
  */
class EventExtendAndConstructTest(name: String) extends Event[String](name) {


  var id: String = _
  override var time: Long = _
  override var content: String = _

  override def parseType(t: String): String = this.getClass.getSimpleName.concat(">>").concat(t)
 
  override def toString():String ={
    id+","+name+","+time+","+content
  }
 
}

object EventExtendAndConstructTest {
 def unapply(test: EventExtendAndConstructTest): Option[(String, String)] = { // case 使用 2参构造的反解析，必须要unapply的2参方法
//    ???
   Some(test.name,test.id)
 }

  def apply(name: String): EventExtendAndConstructTest = {
    val event = new EventExtendAndConstructTest(name)
    event
  }

  def apply(name: String, id: String): EventExtendAndConstructTest = {
    val event = apply(name)
    event.id = id
    event
  }

  def apply(name: String, id: String, time: Long): EventExtendAndConstructTest = {
    val event = apply(name, id)
    event.time = time
    event
  }

  def apply(name: String, id: String, time: Long, content: String): EventExtendAndConstructTest = {
    val event = apply(name, id, time)
    event.content = content
    event
  }

  def main(args: Array[String]) {
    val event = EventExtendAndConstructTest("name","shsh001",1200132392838L,"scjsncjscnsncas");
    event.evenType("adult news!!");
    print(event.toString())

    ////////
    println("");
    println("------222---match -------");
    event match {
     case EventExtendAndConstructTest(name, id) => println(s"name:$name, id:$id")//匹配样式多，得配套unapply
      case e:EventExtendAndConstructTest => println(e.name+"---"+e.id) // 只能匹配种类，用法太少
      case _ => println("not case match!");
    }
  }
}