object ListAndTest {
  // :: , +:, :+, :::, +++4种操作符的区别和联系
  //- :: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为 x :: list,其中 x 为加入到头部的元素，无论 x 是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为 list 的长度 ＋1 ( btw, x :: list 等价于 list.::(x) )
  //- :+ 和 +:两者的区别在于:+ 方法用于在尾部追加元素，+:方法用于在头部追加元素，和 ::很类似，但是 :: 可以用于 pattern match ，而 +: 则不行. 关于  +: 和 :+ ,只要记住冒号永远靠近集合类型就OK了。
  //
  //
  //++ 该方法用于连接两个集合，list1 ++ list2
  //-::: 该方法只能用于连接两个List类型的集合

  def main(args: Array[String]): Unit = {
    //    scala > "A"::"B"::Nil
    //    res0: List[String] = List(A, B)
    val listaa = List("a", "b", "c")
    var str = "A"::"B"::Nil::listaa;
    println(str)
    println(listaa)
    println("----------1-----------")

    //    scala> "A"+:"B"+:Nil
    //    res1: List[String] = List(A, B)
    val listbb = List("a", "b", "c")
    var strbb = "A"+:"B"+:Nil+:listbb;
    println(strbb)

    println("----------2-----------")
    //    scala> Nil:+"A":+"B"
    //    res2: List[String] = List(A, B)
    //
    //    scala> res0 ++ res1
    //    res3: List[String] = List(A, B, A, B)
    //
    //    scala> res0 ::: res1
    //    res4: List[String] = List(A, B, A, B)
    //
    //    scala> res0 :: res1
    //    res5: List[java.io.Serializable] = List(List(A, B), A, B)


  }

}
