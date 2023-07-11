"""
순열로 만들고 부등호가 넘으면 가지치기

완성 된다면 답에 넣어두기
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

k = int(input())

lst = list(input().split())

selected = [0] * (k+1)
visited = [False] * 10

maxValue = '0' * (k+1)
minValue = '9' * (k+1)


def recur(cur):
    if cur == k+1:
        isPossible = True
        for i in range(len(lst)):
            if lst[i] == ">" and selected[i] < selected[i+1]:
                isPossible = False
                break
            if lst[i] == "<" and selected[i] > selected[i+1]:
                isPossible = False
                break
        global maxValue, minValue
        if isPossible:
            result = "".join(map(str, selected))
            maxValue = max(maxValue, result)
            minValue = min(minValue, result)
        return
    for i in range(10):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = i
        recur(cur + 1)
        visited[i] = False


recur(0)

print(maxValue)
print(minValue)