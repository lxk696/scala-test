object Test_BiBao闭包{
//  闭包，和js中的闭包一样，返回值依赖于声明在函数外部的一个或多个变量，那么这个函数就是闭包函数
//  广义而言，所有JS的函数都可以称为闭包，因为JS函数在创建时保存了当前的词法环境
//  js的执行环境本身就是一个scope（浏览器的window/node的global），我们通常称之为全局作用域。每个函数，不论多深，都可以认为是全局scope的子作用域，可以理解为闭包
//  闭包的设计是为了要解决函數自變量問題(Funarg problem)，闭包与自由变量的定义如下:
//    闭包是代码块和创建该代码块的上下文中数据的结合。
//  自由变量是指在函数中使用的，但既不是函数参数也不是函数的局部变量的变量。

//  让一个函数读取一个与自己不同作用域的局部变量

//  在上面的代码中，函数f2就被包括在函数f1内部，这时f1内部的所有局部变量，对f2都是可见的。但是反过来就不行，f2内部的局部变量，对f1 就是不可见的。
//  既然f2可以读取f1中的局部变量，那么只要把f2作为返回值，我们就可以在f1外部读取它的内部变量！


  /* function f1( ... )
   local n = 1
   function f2( ... )
   n = n + 1
   return n
   end
   return f2
   end

   local result = f1()
   print(result())        --2*/


 /* 这种函数叫称之为闭包函数。

  所以，如果要用一句话说明白闭包函数，那就是：函数内在包含子函数，并最终return子函数。

  而闭包函数的最大价值在于：我们可以在函数的外部（即子函数），直接读取该函数的局部变量。

  再仔细研究，就会发现f1()函数就如同一个“类”，而其定义的局部变量就如同该“类”的全局变量；而子函数f2()函数，则如同这个“类”的方法，可以直接使用这个“类”的全局变量n。神奇吧？

  现在总算明白什么是闭包函数了，虽然其实现很神奇，但闭包函数有什么用？
*/
/*  TODO
 1、缓存：最显而易见的好处，就是可以实现数据缓存，我们可以把一个需要长期用到的变量设为闭包函数的局部变量，在子函数里面直接使用它。
  此局部变量只定义初始化一次，但我们可以多次调用子函数并使用该变量。这比起我们在子函数中定义初始化变量，多次调用则多次初始化的做法，
  效率更高。闭包函数常见的一种用途就是，我们可以通过此实现计数功能。在闭包函数定义一个计数变量，而在子函数中对其进行++的操作。
  这样每次调用闭包函数，计数变量就会加1

  2、实现封装：如同前面所说，闭包函数就如同一个“类”，只有在该闭包函数里的方法才可以使用其局部变量，
  闭包函数之外的方法是不能读取其局部变量的。这就实现了面向对象的封装性，更安全更可靠。
  */



}

