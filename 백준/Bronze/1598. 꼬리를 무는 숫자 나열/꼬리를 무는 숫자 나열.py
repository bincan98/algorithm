"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

a, b = map(int, input().split())

print(abs((b - 1) // 4 - (a - 1) // 4) + abs((a - 1) % 4 - (b - 1) % 4))