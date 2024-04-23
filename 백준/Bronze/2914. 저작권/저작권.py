"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

A, I = map(int, input().split())

print(A * (I - 1) + 1)