"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

s = input()

for a in s:
    if a == "e":
        print("ee", end="")
    else:
        print(a, end="")