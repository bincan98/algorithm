"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst1 = list(map(int, input().split()))
lst2 = list(map(int, input().split()))

print(max(sum(lst1), sum(lst2)))