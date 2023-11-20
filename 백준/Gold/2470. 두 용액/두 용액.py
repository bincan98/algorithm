"""
투포인터 두수의 합
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

lst = sorted(lst)

start = 0
end = N - 1

a = lst[start]
b = lst[end]
min_value = abs(lst[start] + lst[end])
while start < end:
    if min_value > abs(lst[start] + lst[end]):
        min_value = abs(lst[start] + lst[end])
        a = lst[start]
        b = lst[end]
    if lst[start] + lst[end] == 0:
        break
    elif lst[start] + lst[end] > 0:
        end -= 1
    else:
        start += 1

print(a, b)