"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

for a in lst:
    if a >= 300:
        print(1, end=" ")
    elif 275 <= a < 300:
        print(2, end=" ")
    elif 250 <= a < 275:
        print(3, end=" ")
    else:
        print(4, end=" ")