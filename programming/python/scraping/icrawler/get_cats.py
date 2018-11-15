from icrawler.builtin import GoogleImageCrawler
crawler = GoogleImageCrawler(storage={"root_dir": "cats"})
crawler.crawl(keyword="猫", max_num=10)
