"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

H = int(input())
M = int(input())

print(H * 60 + M)