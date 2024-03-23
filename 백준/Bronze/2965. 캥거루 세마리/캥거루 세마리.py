"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

a = list(map(int, input().split()))

print(max(a[1] - a[0] - 1, a[2] - a[1] - 1))