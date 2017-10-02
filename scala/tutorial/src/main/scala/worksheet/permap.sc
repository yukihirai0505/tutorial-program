case class Data(num: Int, token: Option[String] = None)

val data = 1 to 100 map (num => Data(num = num))

val tokens = Seq("token-1", "token-2", "token-3")
val limit = 10

val newData = data.grouped(limit).toSeq

newData.zipWithIndex.foreach {
  case (d, i) => d.foreach { s =>
    def getIndex(index: Int): Int = {
      if (index < tokens.length) index
      else getIndex(index - tokens.length)
    }
    println(
      s.copy(token = Some(tokens(getIndex(i))))
    )
  }
}
