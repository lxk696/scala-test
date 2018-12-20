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
