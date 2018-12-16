/**
  * 事件的抽象类，由事件的三要素组成，事件名称、发生时间（时间戳）
  * 事件内容
  *
  * @param name 事件名称
  */
abstract class Event[T](val name: String) {
  var time: Long
  var content: String

  def parseType(t: T): String;

  def evenType(t: T) {
    println("this evenType is :" + parseType(t))
  };
}