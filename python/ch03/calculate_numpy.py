import numpy as np

A = np.array([1, 2, 3, 4])
print(A)

# 1 array -> vector
print(np.ndim(A))
print(A.shape)
print(A.shape[0])

# 2 array -> matrix
B = np.array([[1, 2], [3, 4], [5, 6]])
print(B)
print(np.ndim(B))
print(B.shape)

# calculate multiply
C = np.array([[1, 2], [3, 4]])
print(C.shape)
D = np.array([[5, 6], [7, 8]])
print(D.shape)
print(np.dot(C, D))

E = np.array([[1, 2, 3], [4, 5, 6]])
print(E.shape)
F = np.array([[1, 2], [3, 4], [5, 6]])
print(F.shape)
print(np.dot(E, F))

G = np.array([[1, 2], [3, 4], [5, 6]])
print(G.shape)
H = np.array([7, 8])
print(H.shape)
print(np.dot(G, H))
