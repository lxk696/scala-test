object ToMap extends App {
  var x = Set("a", "b", "c")
    .zipWithIndex //(a,0), (b,1), (c,2)
    .map { case (v, i) => (v, i + 1) } //increment each of those indexes
    .toMap //toMap does work for a collection of Tuples
  println(x)

  var x2 = List("a", "b", "c").zipWithIndex.map { case (v, i) => (v, i + 1) }.toMap
  println(x2)


  // var x3 =List("a","b","c").toMap(x <:(x, x))
  // println(x3)

  var x4 = Set("aa", "bb", "cc") zip Stream.from(1) toMap;
  println(x4)
  var x5 = Set("aa", "bb", "cc").zip(Stream.from(1)).toMap
  println(x5)

  //等价表达式

  def isEven(i: Int) = i % 2 == 0
  List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i))
  List(1, 2, 3, 4).filter(i => isEven(i)).foreach(i => println(i))
  List(1, 2, 3, 4).filter(isEven).foreach(println)
  List(1, 2, 3, 4) filter isEven foreach println

  //= {}2选1 省略def add(a:Int,b:Int){a+b};
}
