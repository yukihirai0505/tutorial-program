package com.example

import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery

object Hello extends JSApp {

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the button!</p>")
  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello world!</p>")
  }

  def main(): Unit = {
    println("Hello, world!")
    jQuery(setupUI _)
  }
}
