import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

lst = sorted(lst)

print(lst[0] * lst[-1])