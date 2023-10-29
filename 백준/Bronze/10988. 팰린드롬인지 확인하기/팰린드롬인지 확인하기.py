import sys

input = lambda: sys.stdin.readline().strip()

s = input()

if s == s[::-1]:
    print(1)
else:
    print(0)