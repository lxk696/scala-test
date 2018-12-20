class TestMyScalaListDef[A] {

  //def ::[B >: A](x : B) : scala.collection.immutable.List[B] = { /* compiled code */ }
  // def ::[B >: A](x: B): List[B]
  def ::[B >: A](x: B): scala.collection.immutable.List[B] = {
    scala.collection.immutable.List(x);
  }

}
