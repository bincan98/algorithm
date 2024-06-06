"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, M, K = map(int, input().split())

print(K // M, K % M)