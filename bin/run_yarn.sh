#! /bin/bash

SPARK_HOME=/Users/xicheng.dong/bigdata/spark-2.1.0-bin-hadoop2.7
APP_JAR=target/examples-1.0-SNAPSHOT.jar
HADOOP_CONF_DIR=/Users/xicheng.dong/bigdata/hadoop-2.7.3/etc/hadoop

$SPARK_HOME/bin/spark-submit \
  --master yarn-client \
  --class org.training.examples.WordCount \
  --num-executors 2 \
  --executor-cores 2 \
  $APP_JAR
