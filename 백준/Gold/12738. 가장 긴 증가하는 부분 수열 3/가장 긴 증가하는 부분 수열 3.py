"""
LIS

https://www.acmicpc.net/problem/12015
와 Ai만 다른듯
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))
lis = [lst[0]]


def binary_search(x):
    start = 0
    end = len(lis) - 1
    find = -1
    while start <= end:
        mid = (start + end) // 2
        if lis[mid] == x:
            return mid
        elif lis[mid] < x:
            start = mid + 1
        else:
            find = mid
            end = mid - 1
    return find


for i in range(N):
    if lis[-1] < lst[i]:
        lis.append(lst[i])
    else:
        idx = binary_search(lst[i])
        lis[idx] = lst[i]

print(len(lis))