package com.example

import org.scalajs.jquery.jQuery

import scala.scalajs.js
import scala.scalajs.js.JSApp

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
    // Scala.jsからJavaScriptを呼び出す
    js.Dynamic.global.alert("Hello, world!")
    jQuery(setupUI _)
  }

}
