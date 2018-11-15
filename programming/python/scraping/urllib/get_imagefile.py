import urllib.request

imgname = "logo_courses_ai.png"
url = "https://aiacademy.jp/assets/images/" + imgname

urllib.request.urlretrieve(url, imgname)
print("done.")
