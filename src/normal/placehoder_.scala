object placehoder_ {
//  占位符语法：
//  scala的函数中用“_”作为占位符，这个占位符可以用传入的参数代替。
//  例如我们写一个f函数：
 val f = (_:Int) +(_:Int)
 println(f(2, 3))
//  占位符还可以用来设置函数的别名：
val a=f _
//  这样a和函数f是等效的，f不用传入参数，直接加个占位符就可以了
//  除了上面的做法，还可以：
 val b = f(1,_:Int)
 println(b(10))

  def echo(args:String*) =
    for(arg<-args) println(arg)
  def main(args : Array[ String]){
    val arr=Array("one", "two","three" )
    // echo(arr) 这是错误的
    echo(arr:_*)//使用“:_*”就是告诉解释器，将数组的中的元素当做一个个参数传入
  }


}
