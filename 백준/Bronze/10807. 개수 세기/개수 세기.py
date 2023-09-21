"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
ls = list(map(int, input().split()))
v = int(input())

cnt = 0
for ele in ls:
    if v == ele:
        cnt += 1
print(cnt)