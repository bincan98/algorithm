"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    n = int(input())
    result = 1
    for i in range(1, n + 1):
        result *= i
    while True:
        if result % 10 == 0:
            result //= 10
        else:
            break
    result %= 10

    print(result)