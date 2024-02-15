"""
완탐?
n이 100_000 2^100_000

그리디?
현재 꽃이 지는 날짜보다 빨리 피는 꽃들 중 제일 늦게까지 피는 꽃
"""
import sys
import heapq

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = []
for _ in range(N):
    a, b, c, d = map(int, input().split())
    lst.append([a, b, c, d])

lst = sorted(lst)

last_month = 3
last_day = 1
answer = 0
pq = []
possible = True
i = 0
while i <= N:
    if last_month == 12:
        break
    if i < N:
        start_month, start_day, end_month, end_day = lst[i]
    if i == N or start_month > last_month or (start_month == last_month and start_day > last_day):
        if len(pq) == 0:
            possible = False
            break
        else:
            answer += 1
            last_month, last_day = heapq.heappop(pq)
            last_month = -last_month
            last_day = -last_day
            pq = []
    if start_month < last_month or (start_month == last_month and start_day <= last_day):
        heapq.heappush(pq, [-end_month, -end_day])
    i += 1

if last_month != 12:
    possible = False

if possible:
    print(answer)
else:
    print(0)