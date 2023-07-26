"""
dp

바이토닉인지 어쩌구 하지만

각 원소에서 LIS와 뒤에서부터의 LIS를 다 구하고 그 합이 각 자리에서 가장 긴 바이토닉 부분 수열일 것이다.
(i는 겹치므로 1을 빼야한다)

dp_lis[i] = i를 마지막으로 하는 가장 긴 증가하는 부분 수열

dp_lis_rev[i] = 리스트의 뒤에서부터 i를 마지막으로 하는 가장 긴 증가하는 부분 수열
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

dp_lis = [1] * N
dp_lis_rev = [1] * N

for i in range(N):
    for j in range(i):
        if lst[j] < lst[i] and dp_lis[i] < (dp_lis[j] + 1):
            dp_lis[i] = dp_lis[j] + 1

for i in range(N)[::-1]:
    for j in range(i + 1, N)[::-1]:
        if lst[j] < lst[i] and dp_lis_rev[i] < (dp_lis_rev[j] + 1):
            dp_lis_rev[i] = dp_lis_rev[j] + 1


answer = 0
for i in range(N):
    answer = max(answer, dp_lis[i] + dp_lis_rev[i] - 1)

print(answer)