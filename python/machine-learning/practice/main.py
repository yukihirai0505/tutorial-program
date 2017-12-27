# coding=utf-8
import numpy as np # NumPy の読み込み
import matplotlib.pyplot as plt # matplotlib の読み込み

v1 = np.array([24, 27, 29, 34, 42, 43, 51]) # 年齢を表すリスト
v2 = np.array([236, 330, 375, 392, 460, 525, 578]) # 価格

plt.xlim(20, 55) # X 軸の範囲を指定
plt.ylim(200, 600) # Y 軸の範囲を指定
plt.xlabel('Age') # X 軸のラベルを年齢に
plt.ylabel('Price') # Y 軸のラベルを価格に
plt.plot(v1, v2, 'o', color="blue") # 描画する
plt.show() # 画面に画像を表示する
plt.savefig("image.png") # 画像をファイル名を付けて保存する