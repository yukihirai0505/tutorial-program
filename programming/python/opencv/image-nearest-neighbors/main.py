# -*- coding: utf-8 -*-
import cv2

# 比較しまくって一番似ている画像を探す といったことができる distance でソートして 最初の distanceが一番近いもの
a_img = cv2.imread('test_img/rabbit03.jpg')
b_img = cv2.imread('test_img/rabbit01.jpg')
# b_img = cv2.imread('test_img/rabbit01.jpg')

# グレー画像に変換
a_gray = cv2.cvtColor(a_img, cv2.COLOR_BGR2GRAY)
b_gray = cv2.cvtColor(b_img, cv2.COLOR_BGR2GRAY)

# AKAZEを使用して特徴量を抽出
akaze = cv2.AKAZE_create()
kp1, des1 = akaze.detectAndCompute(a_gray, None)
kp2, des2 = akaze.detectAndCompute(b_gray, None)

# Brute-force matcher生成
bf = cv2.BFMatcher()

# 特徴量ベクトル同士をBrute-Force＆KNNでマッチング
matches = bf.knnMatch(des1, des2, k=2)

# データを間引きする
ratio = 0.75
good = []
for m, n in matches:
    if m.distance < ratio * n.distance:
        print(m.distance)
        good.append([m])


# matches = bf.match(des1, des2)
# 特徴点同士の距離でソート
# matches = sorted(matches, key=lambda x: x.distance)
# 一番近い距離を抽出
# print(matches[0].distance)

# 上位10個の合計距離とかで判断してもいいかも
# matches[:10]
