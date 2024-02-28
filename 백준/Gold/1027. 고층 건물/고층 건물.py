"""
완탐

각 건물마다 왼쪽과 오른쪽에 보이는 건물의 개수를 구한다
건물의 개수는 기울기로 구함
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
lst = list(map(int, input().split()))

answer = 0
for i in range(n):
    result = 0
    max_slope = lst[i] / 0.5
    for j in range(i)[::-1]:
        if max_slope > (lst[i] - lst[j]) / (i - j):
            max_slope = (lst[i] - lst[j]) / (i - j)
            result += 1
    min_slope = -lst[i] / 0.5
    for j in range(i + 1, n):
        if min_slope < (lst[j] - lst[i]) / (j - i):
            min_slope = (lst[j] - lst[i]) / (j - i)
            result += 1
    answer = max(answer, result)

print(answer)