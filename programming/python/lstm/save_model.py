import time

import numpy as np
from keras.layers import LSTM, Dense
from keras.models import Sequential

from utils import hist_price_dl, price_matrix_creator, normalize_windows


def train_test_split_(price_matrix, train_size=0.9, shuffle=False, return_row=True):
    '''
    It makes a custom train test split where the last part is kept as the training set.
    '''
    price_matrix = np.array(price_matrix)
    # print(price_matrix.shape)
    row = int(round(train_size * len(price_matrix)))
    train = price_matrix[:row, :]
    if shuffle == True:
        np.random.shuffle(train)
    X_train, y_train = train[:row, :-1], train[:row, -1]
    X_test, y_test = price_matrix[row:, :-1], price_matrix[row:, -1]
    X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1], 1))
    X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))
    if return_row:
        return row, X_train, y_train, X_test, y_test
    else:
        X_train, y_train, X_test, y_test


ser = hist_price_dl()  # Not passing any argument since they are set by default
price_matrix = price_matrix_creator(ser)  # Creating a matrix using the dataframe
price_matrix = normalize_windows(price_matrix)  # Normalizing its values to fit to RNN
row, X_train, y_train, X_test, y_test = train_test_split_(
    price_matrix)  # Applying train-test splitting, also returning the splitting-point

# LSTM Model parameters, I chose
batch_size = 2  # Batch size (you may try different values)
epochs = 15  # Epoch (you may try different values)
seq_len = 30  # 30 sequence data (Representing the last 30 days)
loss = 'mean_squared_error'  # Since the metric is MSE/RMSE
optimizer = 'rmsprop'  # Recommended optimizer for RNN
activation = 'linear'  # Linear activation
input_shape = (None, 1)  # Input dimension
output_dim = 30  # Output dimension

model = Sequential()
model.add(LSTM(units=output_dim, return_sequences=True, input_shape=input_shape))
model.add(Dense(units=32, activation=activation))
model.add(LSTM(units=output_dim, return_sequences=False))
model.add(Dense(units=1, activation=activation))
model.compile(optimizer=optimizer, loss=loss)

start_time = time.time()
model.fit(x=X_train,
          y=y_train,
          batch_size=batch_size,
          epochs=epochs,
          validation_split=0.05)
end_time = time.time()
processing_time = end_time - start_time

model.save('coin_predictor.h5')
