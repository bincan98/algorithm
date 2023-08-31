import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

result = 0
for i in range(2, n+1):
    result += (n // i - 1) * i

print(result % 1_000_000)