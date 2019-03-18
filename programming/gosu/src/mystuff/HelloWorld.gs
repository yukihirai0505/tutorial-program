package mystuff

class HelloWorld {
  public static function main(args : String[]) {
    var message = "Hello Gosu!"
    print(message)
    var colors = {
        "red",
        "green",
        "blue"
    }
    colors.forEach(\s -> print(s))
  }
}