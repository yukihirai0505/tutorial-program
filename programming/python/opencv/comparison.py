import cv2
import os
import numpy as np
from PIL import Image

# トレーニング画像
train_path = './train_images'

# テスト画像
test_path = './test_images'

# Haar-like特徴分類器
cascadePath = "data/haarcascades/haarcascade_frontalface_default.xml"
# for anime
# cascadePath = "./lbpcascade_animeface.xml"
faceCascade = cv2.CascadeClassifier(cascadePath)

# FisherFace
# recognizer = cv2.face_FisherFaceRecognizer.create()
recognizer = cv2.face_LBPHFaceRecognizer.create()

# pathしたフォルダ内の画像を習得
def get_images_and_labels(path):
    # 画像を格納する配列
    images = []
    # ラベルを格納する配列
    labels = []
    # ファイル名を格納する配列
    files = []
    for f in os.listdir(path):
        # 画像のパス
        image_path = os.path.join(path, f)
        # グレースケールで読み込み
        image_pil = Image.open(image_path).convert('L')
        # Numpyの配列に格納
        image = np.array(image_pil, 'uint8')
        # Haar-like特徴分類器で顔を検知
        faces = faceCascade.detectMultiScale(image)
        # 顔認識できてるかチェック
        print("===Result: faceCascade.detectMultiScale===")
        print(faces)
        # 検出した画像の処理
        for (x, y, w, h) in faces:
            # 200×200にリサイズ
            roi = cv2.resize(image[y: y + h, x: x + w], (200, 200), interpolation=cv2.INTER_LINEAR)
            # 画像を配列に格納
            images.append(roi)
            # ファイル名からラベルを取得
            labels.append(int(f[7:9]))
            # ファイル名を配列に格納
            files.append(f)

    return images, labels, files


# トレーニング画像を取得
images, labels, files = get_images_and_labels(train_path)

# トレーニング実施
recognizer.train(images, np.array(labels))

# テスト画像を取得
test_images, test_labels, test_files = get_images_and_labels(test_path)

i = 0
while i < len(test_labels):
    # テスト画像に対して予測実施
    label, confidence = recognizer.predict(test_images[i])
    # 予測結果をコンソール出力
    print("Test Image: {}, Predicted Label: {}, Confidence: {}".format(test_files[i], label, confidence))
    # テスト画像表示
    # cv2.imshow("test image", test_images[i])
    # cv2.waitKey(300)
    i += 1

# 終了処理
cv2.destroyAllWindows()
