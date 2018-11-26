import json

import pandas as pd
import requests


# https://api.coinranking.com/v1/public/coin/:coin_id/history/:timeframe
# https://docs.coinranking.com/
def hist_price_dl(coin_id=1335, timeframe="5y", currency="USD"):
    '''It accepts coin_id, timeframe, and currency parameters to clean the historic coin data taken from COINRANKING.COM
    It returns a Pandas Series with daily mean values of the selected coin in which the date is set as the index'''
    r = requests.get(
        "https://api.coinranking.com/v1/public/coin/" + str(coin_id) + "/history/" + timeframe + "?base=" + currency)
    coin = json.loads(r.text)['data']['history']  # Reading in json and cleaning the irrelevant parts
    df = pd.DataFrame(coin)
    df['price'] = pd.to_numeric(df['price'])
    df['timestamp'] = pd.to_datetime(df['timestamp'], unit='ms').dt.date
    return df.groupby('timestamp').mean()['price']


def price_matrix_creator(data, seq_len=30):
    '''
    It converts the series into a nested list where every item of the list contains historic prices of 30 days
    '''
    price_matrix = []
    for index in range(len(data) - seq_len + 1):
        price_matrix.append(data[index:index + seq_len])
    return price_matrix


def normalize_windows(window_data):
    '''
    It normalizes each value to reflect the percentage changes from starting point
    '''
    normalised_data = []
    for window in window_data:
        normalised_window = [((float(p) / float(window[0])) - 1) for p in window]
        normalised_data.append(normalised_window)
    return normalised_data
