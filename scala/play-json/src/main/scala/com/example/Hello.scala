package com.example

import play.api.libs.functional.syntax._
import play.api.libs.json._

object Hello extends App {

  case class Person(fullName: String, age: Int)

  implicit val personReads = (
    (__ \ "full_name").read[String] ~
      (__ \ "age").read[Int]
    ) (Person)

  val samplePersonJson = Json.obj(
    "full_name" -> "Nico Yazawa",
    "age" -> 17
  )

  val person = Json.fromJson[Person](samplePersonJson).get
  print(person.age)

  val rawString =
    """
      |{
      |  "name": "Alice",
      |  "age": 20,
      |  "favorites": ["tennis", "swimming"],
      |  "family": [
      |    {
      |      "name": "Bob",
      |      "relation": "father"
      |    },
      |    {
      |      "name": "Catharin",
      |      "relation": "mother"
      |    }
      |  ]
      |}
    """.stripMargin

  // String to JsValue
  // `Json.parse` throws exception for invalid input
  val json: JsValue = Json.parse(rawString)
  println(s"parsed json: ${json \ "name"}")

  // JsValue to String
  // `Json.prettyPrint` is also available to print pretty json
  println(s"reversed to string: ${Json.stringify(json)}")
}
