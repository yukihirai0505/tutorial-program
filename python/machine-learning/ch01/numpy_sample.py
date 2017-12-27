# numpy <- it is useful to calculate array and matrix
import numpy as np

x = np.array([1.0, 2.0, 3.0])
print(x / 2.0)
# numpy.ndarray
print(type(x))

# calculate array <- it is necessary to be element-wise
y = np.array([2.0, 4.0, 6.0])
print(x + y)
print(x - y)
print(x * y)
print(x / y)

A = np.array([[1, 2], [3, 4]])
print(A)
# 2 × 2
print(A.shape)
# int64
print(A.dtype)

# calculate matrix
B = np.array([[3, 0], [0, 6]])
print(A + B)
print(A * 10)

# numpy can create N array
# in math, we call
# 1 array to vector
# 2 array to array
# more then 3 array to tensor

# in calculate A * 10, 10 becomes 2 × 2
# it is called by broadcast
# so we can calculate different size array

C = np.array([[1, 2], [3, 4]])
D = np.array([10, 20])
print(C * D)

# to access ndarray
X = np.array([[51, 55], [14, 19], [0, 4]])
print(X)
print(X[0])
print(X[0][1])

for row in X:
    print(row)

# n array to vector
X = X.flatten()
print(X)
# to get index number 0, 2, 4
print(X[np.array([0, 2, 4])])
# so we can get element by condition
# X > 15 will be the result array [True, True, False, True, False, False, dtype=bool]
print(X > 15)
print(X[X > 15])
