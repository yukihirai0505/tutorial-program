def AND(x1, x2):
    w1, w2, theta = 0.5, 0.5, 0.7
    tmp = x1 * w1 + x2 * w2
    if tmp <= theta:
        print(0)
    elif tmp > theta:
        print(1)

AND(0, 0)
AND(1, 0)
AND(0, 1)
AND(1, 1)
