class Test_Reference_T[T] {
  private var contents: T = _

  def set(value: T) {
    contents = value
  }

  def get: T = contents
}

object Test_Reference_T {
  def main(args: Array[String]) {
    val cell = new Test_Reference_T[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))
  }
}