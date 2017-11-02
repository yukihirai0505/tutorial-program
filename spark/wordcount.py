#!/usr/bin/env python
# coding:utf-8

from pyspark import SparkContext


def execute(sc, src, dest):
    """
    ワードカウントを実行する
    """
    # srcファイルを読み込み
    text_file = sc.textFile(src)
    counts = text_file.flatMap(lambda line: line.split(" ")) \
        .map(lambda word: (word, 1)) \
        .reduceByKey(lambda a, b: a + b)
    # 結果を書き出し
    counts.saveAsTextFile(dest)


if __name__ == '__main__':
    sc = SparkContext('local', 'WordCount')
    src = './input'
    dest = './output'
    execute(sc, src, dest)
