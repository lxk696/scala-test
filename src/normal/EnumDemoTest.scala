import EnumerationDemo._
/**https://blog.csdn.net/wangxiaotongfan/article/details/48242029
  *
  * 枚举的引用
  * 可以直接objectName.red这样来进行引用，也可以将import objectName._来进行导入引用，还可以给枚举类型增加一个类型别名，
  * 具体如下： type EnumerationDemo = Value
  * 现在枚举类型变成了EnumerationDemo.EnumerationDemo 这种用法只有在使用import语句的时候才显得有意义。
  * import EnumerationDemo._
  * 枚举类型也可以通过for循环将所有元素输出，同时可以通过Enumeration（Int）和Enumeration.withName（""）来进行 定位操作
  * */
class EnumDemoTest {
  def transportation(color:Enumeration): Unit ={
    if (color == red)
      "Stop"
    else if (color == green)
      "go"
    else if (color == yellow)
      "wait"
  }
}
