# GETリクエスト
import requests

res = requests.get("https://aiacademy.jp")
print(res) # <Response [200]>

print(res.text) # 帰って来たレスポンスボディをテキスト形式で取得

# .contentを使うと、レスポンスボディをバイナリ形式で取得
