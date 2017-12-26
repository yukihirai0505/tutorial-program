package models

case class SampleEntity(username: String, email: String, profilePicUrl: Option[String] = None) {
  require(!username.isEmpty, "username.empty")
  require(!email.isEmpty, "password.empty")
}