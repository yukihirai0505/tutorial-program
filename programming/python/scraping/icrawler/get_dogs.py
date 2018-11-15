from icrawler.builtin import GoogleImageCrawler
crawler = GoogleImageCrawler(storage={"root_dir": "dogs"})
crawler.crawl(keyword="犬", max_num=10)
