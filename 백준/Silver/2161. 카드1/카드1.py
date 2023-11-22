"""
냅다 큐로 구현
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = deque([i for i in range(1, N+1)])

while lst:
    print(lst.popleft(), end=" ")
    if lst:
        lst.append(lst.popleft())