from icrawler.builtin import GoogleImageCrawler
crawler = GoogleImageCrawler(storage={"root_dir": "rabbits"})
crawler.crawl(keyword="うさぎ", max_num=100)
