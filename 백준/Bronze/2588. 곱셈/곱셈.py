import sys

input = lambda: sys.stdin.readline().strip()

a = int(input())
b = list(map(int, input()))

c = 0
for i in range(3)[::-1]:
    print(a * b[i])

for i in range(3):
    c *= 10
    c += b[i]

print(a * c)