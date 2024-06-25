"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

A, B = map(int, input().split())

print(min(A // 2, B))