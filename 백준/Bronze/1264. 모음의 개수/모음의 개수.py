"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

mo = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
s = list(input())
while s[0] != '#':
    result = 0
    for a in s:
        if a in mo:
            result += 1
    print(result)
    s = list(input())