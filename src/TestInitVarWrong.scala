class TestInitVarWrong {
  val foo = 10
  val bar = foo
}

//class Bar extends { override val foo = 20 }  with TestInitVarWrong {
//  override val foo = 20
//}

//class Bar extends TestInitVarWrong {
//  override val foo = 20
//}

object TestInitVarWrong extends App {

//  class Bar extends { override val foo = 20 }  with TestInitVarWrong {   //  可以采用提前定义，相当于使用特质来避免
//
//  }
//  println(new Bar().bar)//期待是 20 ，结果是20，不是0  也不是10


  class Bar extends  TestInitVarWrong {
    override val foo = 20
  }
  println(new Bar().bar)//期待是 20 ，结果是0，不是20 也不是10
  //反编译后，  解释成 java
//  public class Foo {
//
//    private final int foo;
//    private final int bar;
//
//    public int foo() {
//      return foo ;
//    }
//
//    public int bar() {
//      return bar ;
//    }
//
//    public Foo() {
//      foo = 10;
//      bar = foo();
//  TODO    这个时候bar的值是通过foo()来获得的，foo()这个时候是Bar.foo()，因此foo()返回的是Bar.foo的值。这个时候，Bar.foo还没有被初始化，所以它的值还是0，bar就被设置为0了。
//      从这个case可以看到，Scala中的val和Java的field是不一样的，如果忘记这一点，很容易掉进这样的坑里去。
//    }
//  }
//
//  public class Bar extends Foo {
//
//    private final int foo;
//
//    public int foo() {
//      return foo ;
//    }
//
//    public Bar() {
//      super();
//      foo = 20;
//    }
//
//    public static void main(String[] args) {
//      System.out.println(new Bar().bar());
//    }
//  }
}