#! /bin/bash

SPARK_HOME=/Users/xicheng.dong/bigdata/spark-2.1.0-bin-hadoop2.7
APP_JAR=target/examples-1.0-SNAPSHOT.jar

$SPARK_HOME/bin/spark-submit \
  --master local \
  --class org.training.examples.WordCount \
  $APP_JAR
