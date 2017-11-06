package com.example

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Yuky on 2017/11/06.
  */
object StartupPostOffice extends App {
  def printRDD(filterName: String, rdd: org.apache.spark.rdd.RDD[_]) = {
    println(filterName)

    rdd.foreach { r => {
      println(r)
    }
    }
  }

  val conf = new SparkConf().setAppName("RddSample").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val inputRDD = sc.textFile("KEN_All_ROME.CSV")

  //mapの例
  val addresses = inputRDD.map { line =>
    val splited = line.replace("\"", "").split(",")

    var result: Array[String] = null
    if (splited(6) == "IKANIKEISAIGANAIBAAI")
      result = Array(splited(0), splited(4), splited(5))
    else
      result = Array(splited(0), splited(4), splited(5), splited(6))

    result.mkString(" ")
  }

  printRDD("mappedRDD", addresses)

  //filterとunionの例
  val filtered1 = addresses.filter(line => line.contains("OSAKA")).filter(line => line.contains("AOBADAI"))
  val filtered2 = addresses.filter(line => line.contains("KANAGAWA")).filter(line => line.contains("WAKABADAI"))
  val unioned = filtered1.union(filtered2)

  printRDD("filtered RDD 1", filtered1)
  printRDD("filtered RDD 2", filtered2)
  printRDD("unioned RDD", unioned)

  //flatMapの例
  val flatmapped = unioned.flatMap(line => line.split(" "))
  printRDD("flatmapped", flatmapped)

  //reduceの例
  val reduced = flatmapped.reduce((x, y) => x + " " + y)
  println("reduced")
  println(reduced)

  //countの例
  val count = inputRDD.count
  println("count")
  println(count)


}
