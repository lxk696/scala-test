class CompareDate(y: Int, m: Int, d: Int) extends Ord {
  def year = y

  def month = m

  def day = d

  override def toString(): String = year + "-" + month + "-" + day;

  override def equals(that: Any): Boolean =
    that.isInstanceOf[CompareDate] && {
      val o = that.asInstanceOf[CompareDate]
      o.day == day && o.month == month && o.year == year
    }

  //  override def <(that: Any): Boolean = ???


  def error(str: String) = println(str)

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[CompareDate])
      error("cannot compare " + that + " and a Date")
    val o = that.asInstanceOf[CompareDate]
    (year < o.year) ||
      (year == o.year && (month < o.month ||
        (month == o.month && day < o.day)))
  }
}
