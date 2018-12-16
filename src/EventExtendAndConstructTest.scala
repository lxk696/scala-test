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
  }
}