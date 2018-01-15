#!/bin/bash


export  SPARK_MASTER_IP=127.0.0.1
export  SPARK_LOCAL_IP=127.0.0.1

rm -fR ./output
/usr/local/bin/spark-submit ./wordcount.py

echo ">>>>> result"
cat ./output/*
