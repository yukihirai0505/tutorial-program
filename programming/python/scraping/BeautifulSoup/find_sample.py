from bs4 import BeautifulSoup
from urllib.request import urlopen
html = urlopen("https://aiacademy.jp/assets/scraping/sample1.html")
data = html.read()
html = data.decode('utf-8')

# HTMLを解析
soup = BeautifulSoup(html, 'html.parser')

# 解析したHTMLから任意の部分のみを抽出（ここではtitleとbody）
title = soup.find("title")
body = soup.find("body")

print("title: " + title.text)
print("body: " + body.text)
