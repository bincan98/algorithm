import sys
from heapq import heappush, heappop

input = sys.stdin.readline

heap = []

n = int(input())
for i in range(n):
  a = int(input())
  if a < 0:
    heappush(heap, (-a - 0.5, a))
  elif a > 0:
    heappush(heap, (a, a))
  else:
    if heap:
      print(heappop(heap)[1])
    else:
      print(0)