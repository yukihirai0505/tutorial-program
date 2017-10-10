

val caption = "このワンピースフリマで売る為に撮影したけど今日暑すぎ\\uD83D\\uDE25#instadaily#ootd#outfit#me#fashion#ファッション#outfit#instafashion#coode#makeup#coordinat#ファッション#コーディネート#ヘアアレンジ#着こなし#fashion #fashionstyle #outfits #fashionlover#fashionable#フォローミー#me#selfie #i#selfies#셀카#셀피#셀스타그램#얼스타그램#친스타그램#歌舞伎町"
val pattern = """#[a-zA-Z0-9_\u3041-\u3094\u3099-\u309C\u30A1-\u30FA\u3400-\uD7FF\uFF10-\uFF19\uFF20-\uFF3A\uFF41-\uFF5A\uFF66-\uFF9E|\w-ー]*""".r

pattern.findAllIn(caption).toSeq.foreach(println)