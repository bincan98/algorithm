"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

print(N * M // 2)