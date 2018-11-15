from bs4 import BeautifulSoup

from bs4 import BeautifulSoup
from urllib.request import urlopen
html = urlopen("https://aiacademy.jp/assets/scraping/sample2.html")
data = html.read()
html = data.decode('utf-8')

soup = BeautifulSoup(html, 'html.parser')

links = soup.find_all("a")

for a in links:
    href = a.attrs['href']
    text = a.text
    print(text, href)
