"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    s = input()
    last = ''
    for a in s:
        if last != a:
            print(a, end= "")
            last = a
    print()