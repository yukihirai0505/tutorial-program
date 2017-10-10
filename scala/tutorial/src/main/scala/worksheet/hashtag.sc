

val caption = "ことこと屋でオムライス⑅︎◡̈︎* 今週もよく頑張りました♡\n\n#オムライス\n\n#ことこと屋\n\n#外食\n\n#夕飯\n\n#ごちそうさま\n\n#ニコニコ\n\n#好きなもの\n\n#美味しい"
val pattern = """#[a-zA-Z0-9_\u3041-\u3094\u3099-\u309C\u30A1-\u30FA\u3400-\uD7FF\uFF10-\uFF19\uFF20-\uFF3A\uFF41-\uFF5A\uFF66-\uFF9E|\w-]*""".r

pattern.findAllIn(caption).toSeq