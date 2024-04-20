"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

for i in range(n // 5):
    print("V", end="")

for i in range(n % 5):
    print("I", end="")