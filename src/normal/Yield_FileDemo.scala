import scala.io.Source

object Yield_FileDemo {
  lazy val files = (new java.io.File("C:\\Users\\admin\\Desktop\\test")).listFiles
  // 输出指定目录下的所有文件
  /*for(file <- files)
{
    println(file)
}*/

  def fileLines(file: java.io.File) = {
    Source.fromFile(file).getLines.toList
  }

  def main(args: Array[String]): Unit = {
    println(files.length)

    val lengths =
      for {
        // 获取以.txt结尾的文件
        file <- files if file.getName.endsWith(".txt")
//        file<- {println(file getName);file}
        line <- fileLines(file)

        trimmedLine = line.trim
//        () <- println(file getName)
        if trimmedLine.matches(".*love.*")
      } yield line + "：合计" + trimmedLine.length + "个字。"
    lengths.foreach(println)
  }
}
