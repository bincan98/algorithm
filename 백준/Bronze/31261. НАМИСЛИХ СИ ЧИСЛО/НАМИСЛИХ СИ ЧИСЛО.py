"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

a, b = map(int, input().split())

print((a + b + 1) * a * a)