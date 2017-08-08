# coding: utf-8
import numpy as np
import matplotlib.pyplot as plt

# create data
x = np.arange(0, 6, 0.1) # from 0 to 6 by 0.1
print(x)
y1 = np.sin(x)
y2 = np.cos(x)

# Draw graph
plt.plot(x, y1, label="sin")
# using dot line
plt.plot(x, y2, linestyle="--", label="cos")
plt.xlabel("x")
plt.ylabel("y")
plt.title("sin & cos")
plt.legend()
plt.show()
