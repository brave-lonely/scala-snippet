package codeanalyze

/**
  * Created by xiangyang on 2017/5/14.
  */
class SourceCode(val path: String, val name: String, private val lines: List[String]) {
  def count: Int = lines.length
}

object SourceCode {
  def fromFile(path: String): SourceCode = {
    import scala.io.Source
    val source = Source.fromFile(path)
    val lines = source.getLines.toList
    val fileName = path.split("/").last
    new SourceCode(path, fileName, lines)
  }
}
