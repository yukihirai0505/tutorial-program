case class Data(num: Int, token: Option[String] = None)

val data = 1 to 35 map (num => Data(num = num))

val tokens = Seq("token-1", "token-2", "token-3")
val limit = 10

val newData = data.grouped(limit).toSeq

// TODO: ブラッシュアップ
newData.zipWithIndex.foreach {
  case (d, i) => d.foreach { s =>
    println(
      if (i < tokens.length) {
        s.copy(token = Some(tokens(i)))
      } else {
        val index = i - tokens.length
        s.copy(token = Some(tokens(index)))
      }
    )
  }
}
