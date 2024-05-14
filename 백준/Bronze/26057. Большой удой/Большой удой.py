"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

L = int(input())
T = int(input())

print(T - (L - T))