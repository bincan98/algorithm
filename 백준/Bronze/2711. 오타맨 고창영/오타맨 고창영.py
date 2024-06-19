"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    n, s = input().split()
    for i in range(len(s)):
        if i == int(n) - 1:
            continue
        print(s[i], end="")
    print()