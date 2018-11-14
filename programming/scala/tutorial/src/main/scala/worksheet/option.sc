val none: Option[Int] = None
none.map(_.toString)

val some: Option[Int] = Some(1)
some.map(_.toString)

!Seq(200, 400).contains(200)
!Seq(200, 400).contains(400)
!Seq(200, 400).contains(500)

val statusCode = 200
statusCode != 200 || statusCode != 400