from urllib.request import urlopen
html = urlopen("https://aiacademy.jp")
data = html.read()
decoded_data = data.decode('utf-8')
print(decoded_data)
