object TestTupleAndListAndMap extends App {

  println("----1-------------")


  val testList = List(1, 2, 3, 4, 5)
  testList.foreach((x: Int) => println(x))

  testList.filter((x: Int) => x > 3)
  val b1 = (x: Int) => (y: Int) => x + y
  println(b1(1)(2))

  val b2: (Int, Int) => Int = (x, y) => x + y
  println(b2(1, 2))

  println("----2-------------")

  val tuple3, (name, age, sex) = ("张三", 12, "男")
  println(tuple3)
  println(name)
  println(age)
  println(sex)

  val arr1 = Array("a", "b", "c")
  val arr2 = Array("A", "B", "C")
  val tuple = arr1 zip arr2
  println(tuple.toBuffer) //ArrayBuffer((a,A), (b,B), (c,C))
  println(tuple(0)._1) //a
  println("----3-------------")


  /**
    * 不可变长映射
    */
  //使用元组的形式定义map
  val map1 = Map(("a", "A"), ("b", "B"))
  //使用箭头的形式
  val map2 = Map("a" -> "A", "b" -> "B", "c" -> "C")
  //两者混合的形式
  val map3 = Map(("a" -> "A"), "b" -> "B")
  //++ 合并两个map，形成一个新的map
  val map4 = map1 ++ map2
  println(map4) //Map(a -> A, b -> B, c -> C)
  /**
    * 可变长Map映射
    */
  val map5 = scala.collection.mutable.Map("a" -> "A")
  map5 put("b", "B")
  map5 += ("c" -> "C", "d" -> "D")
  map5 += (("e", "E"), ("f" -> "F"))
  map5 ++= Map("j" -> "J")
  println(map5) //Map(e -> E, b -> B, j -> J, d -> D, a -> A, c -> C, f -> F)
  //移除map中的key
  map5 -= "a"
  map5 --= Set("b", "c")
  map5 remove ("d")
  println(map5) //Map(e -> E, j -> J, f -> F)

  println("----4-------------")

}

class TestTupleAndListAndMap[A] {

  // def ::[B >: A](x: B): List[B]

  //def ::[B >: A](()x: B): List[B])
  //def ::[B >: A](x : B) : scala.collection.immutable.List[B] = { /* compiled code */ }


}
