package org.training.examples

import org.apache.spark._

object WordCount {
  def main(args: Array[String]) {
    var masterUrl = "local[1]"
    var inputPath = "data/"

    if (args.length == 1) {
      masterUrl = args(0)
    } else if (args.length == 3) {
      masterUrl = args(0)
      inputPath = args(1)
    }

    println(s"masterUrl:${masterUrl}, inputPath: ${inputPath}")

    val sparkConf = new SparkConf().setMaster(masterUrl).setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rowRdd = sc.textFile(inputPath)
    val resultRdd = rowRdd.flatMap(line => line.split("\\s+"))
        .map(word => (word, 1)).reduceByKey(_ + _)

    resultRdd.take(20).foreach(println)
  }
}
