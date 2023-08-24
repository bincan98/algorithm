"""
큐
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

lst = [i for i in range(1, N+1)]

lst = deque(lst)

answer = []
while lst:
    for i in range(K-1):
        lst.append(lst.popleft())
    answer.append(lst.popleft())

print("<", ", ".join(map(str, answer)), ">", sep="")