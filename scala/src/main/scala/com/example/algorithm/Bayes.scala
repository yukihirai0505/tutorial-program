package com.example.algorithm

/**
  * author Yuki Hirai on 2017/09/01.
  */
object Bayes extends App {
  def bayes(x: Double, y: Double, yx: Double): Double = yx * x / y

  def basicTest() = {
    // コーヒーを買った人の割合
    val x = 0.7
    // クッキーを買った人の割合
    val y = 0.6
    // コーヒーを買った人の中でクッキーを買った人の割合
    val yx = 0.5
    println(bayes(x, y, yx))
  }
  basicTest()

  // 箱Aには白玉4個と赤玉1個、箱Bには白玉1個と赤玉9個が入っている
  // 1/2ずつの確率でどちらかの箱を選んで中身をひとつとった時、白玉がでてきました。
  // この時は、どちらの箱からとった可能性が高いか

  def boxATest() = {
    // 箱Aが選ばれる確率
    val x = 0.5
    // 白が出る確率
    val y = (4.0 / 5) * 0.5 + (1.0 / 10) * 0.5
    // 箱Aの中で白が出る確率
    val yx = 4.0 / 5
    println(bayes(x, y, yx))
  }
  boxATest()

  def boxBTest() = {
    // 箱Bが選ばれる確率
    val x = 0.5
    // 白が出る確率
    val y = (4.0 / 5) * 0.5 + (1.0 / 10) * 0.5
    // 箱Bの中で白が出る確率
    val yx = 1.0 / 10
    println(bayes(x, y, yx))
  }
  boxBTest()

}