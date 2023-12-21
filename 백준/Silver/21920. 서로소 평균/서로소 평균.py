import sys

input = lambda: sys.stdin.readline().strip()


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


N = int(input())
lst = list(map(int, input().split()))
X = int(input())

cnt = 0
total = 0
for a in lst:
    result = 0
    if a > X:
        result = gcd(a, X)
    else:
        result = gcd(X, a)
    if result == 1:
        cnt += 1
        total += a

print(total / cnt)