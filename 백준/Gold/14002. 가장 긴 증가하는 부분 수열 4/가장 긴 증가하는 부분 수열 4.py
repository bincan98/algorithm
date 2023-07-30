"""
dp

dp_lis[i] = i를 마지막으로 하는 가장 긴 증가하는 부분 수열

prev에 그전 수열이 뭔지 저장해두자
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

dp_lis = [1] * N
prev = [i for i in range(N)]

for i in range(N):
    for j in range(i):
        if lst[j] < lst[i] and dp_lis[i] < (dp_lis[j] + 1):
            dp_lis[i] = dp_lis[j] + 1
            prev[i] = j

answer = -1
idx = -1
for i in range(N):
    if answer <= dp_lis[i]:
        answer = dp_lis[i]
        idx = i

answer_lst = []
answer_lst.append(lst[idx])
while prev[idx] != idx:
    idx = prev[idx]
    answer_lst.append(lst[idx])


answer_lst = sorted(answer_lst)

print(answer)
print(*answer_lst)