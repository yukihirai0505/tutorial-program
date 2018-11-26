import numpy as np
from keras.models import load_model

from utils import hist_price_dl, price_matrix_creator, normalize_windows

# We need ser, preds, row
ser = hist_price_dl(timeframe='30d')[1:31]
price_matrix = price_matrix_creator(ser)
X_test = normalize_windows(price_matrix)
X_test = np.array(X_test)
X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))

model = load_model('coin_predictor.h5')
preds = model.predict(X_test, batch_size=2)


def deserializer(preds, data, train_size=0.9, train_phase=False):
    '''
    Arguments:
    preds : Predictions to be converted back to their original values
    data : It takes the data into account because the normalization was made based on the full historic data
    train_size : Only applicable when used in train_phase
    train_phase : When a train-test split is made, this should be set to True so that a cut point (row) is calculated based on the train_size argument, otherwise cut point is set to 0

    Returns:
    A list of deserialized prediction values, original true values, and date values for plotting
    '''
    price_matrix = np.array(price_matrix_creator(ser))
    if train_phase:
        row = int(round(train_size * len(price_matrix)))
    else:
        row = 0
    date = ser.index[row + 29:]
    date = np.reshape(date, (date.shape[0]))
    X_test = price_matrix[row:, :-1]
    y_test = price_matrix[row:, -1]
    preds_original = []
    preds = np.reshape(preds, (preds.shape[0]))
    for index in range(0, len(preds)):
        pred = (preds[index] + 1) * X_test[index][0]
        preds_original.append(pred)
    preds_original = np.array(preds_original)
    if train_phase:
        return [date, y_test, preds_original]
    else:
        import datetime
        return [date + datetime.timedelta(days=1), y_test]


final_pred = deserializer(preds, ser, train_size=0.9, train_phase=False)
# Tomorrow Data
print(final_pred[1][0])
