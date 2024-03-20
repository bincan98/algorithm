"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst1 = list(map(int, input().split()))
lst2 = list(map(int, input().split()))

answer = 0
for i in range(3):
    answer += max(0, lst2[i] - lst1[i])

print(answer)