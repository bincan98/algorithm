import sys
import heapq

input = lambda: sys.stdin.readline().strip()

N = int(input())

pq = []
heapq.heapify(pq)

for i in range(N):
    a = int(input())
    if a == 0:
        if pq:
            print(heapq.heappop(pq))
        else:
            print(0)
    else:
        heapq.heappush(pq, a)