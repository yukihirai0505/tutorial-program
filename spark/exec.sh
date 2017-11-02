#!/bin/bash

rm -fR ./output
/usr/local/bin/spark-submit ./wordcount.py

echo ">>>>> result"
cat ./output/*