import numpy as np


# it may cause an overflow error
def softmax_overflow(a):
    exp_a = np.exp(a)
    sum_exp_a = np.sum(exp_a)
    y = exp_a / sum_exp_a

    return y

def softmax(a):
    c = np.max(a)
    exp_a = np.exp(a - c) # for overflow
    sum_exp_a = np.sum(exp_a)
    y = exp_a /sum_exp_a

    return y

a = np.array([0.3, 2.9, 4.0])

exp_a = np.exp(a)
print(exp_a)

sum_exp_a = np.sum(exp_a)

print(sum_exp_a)

y = exp_a / sum_exp_a
print(y)

# fix overflow
b = np.array([1010, 1000, 990])
print(np.exp(a) / np.sum(np.exp(a)))
# -> array([ nan, nan, nan])

c = np.max(b)
print(b - c)
# -> array([ 0, -10, -20])

print(np.exp(b - c) / np.sum(np.exp(b - c)))
# -> array([ 9.999546e-01, 4.53978686e-05, 2.06106005e-09])

# softmax result
d = np.array([0.3, 2.9, 4.0])
z = np.sum(d)
print(z)
# -> [ 0.01821127, 0.24519181, 0.736559691]
print(np.sum(z))
# -> 1.0