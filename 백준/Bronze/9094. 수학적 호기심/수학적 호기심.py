"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    n, m = map(int, input().split())
    answer = 0
    for a in range(1, n):
        for b in range(a + 1, n):
            if (pow(a, 2) + pow(b, 2) + m) / (a * b) == (pow(a, 2) + pow(b, 2) + m) // (a * b):
                answer += 1
    print(answer)