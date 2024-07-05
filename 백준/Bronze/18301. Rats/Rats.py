"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

a, b, c = map(int, input().split())

print((a + 1) * (b + 1) // (c + 1) - 1)