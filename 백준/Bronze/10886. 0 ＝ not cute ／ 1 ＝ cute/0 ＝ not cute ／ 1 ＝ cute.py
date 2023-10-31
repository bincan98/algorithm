import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

a = 0
b = 0
for i in range(N):
    c = int(input())
    if c == 1:
        a += 1
    else:
        b += 1

if a > b:
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")