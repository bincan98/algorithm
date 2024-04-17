"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

print((sum(lst) + (N - 1) * 8) // 24, end=" ")
print((sum(lst) + (N - 1) * 8) % 24)