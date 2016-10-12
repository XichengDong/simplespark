package org.training.examples

import org.apache.spark._

object WordCount {
  def main(args: Array[String]) {
    var masterUrl = "local[1]"
    if (args.length > 0) {
      masterUrl = args(0)
    }
    val inputPath = "/Users/xicheng.dong/training-examples/ml-1m/README"
    val outputPath = "/tmp/output"

    val sparkConf = new SparkConf().setMaster(masterUrl).setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rowRdd = sc.textFile(inputPath)
    val resultRdd = rowRdd.flatMap(line => line.split("\\s+"))
        .map(word => (word, 1)).reduceByKey(_ + _)

    resultRdd.count()

    resultRdd.first()

    resultRdd.saveAsTextFile(outputPath)
  }
}
