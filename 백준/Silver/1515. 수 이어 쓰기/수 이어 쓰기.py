import sys
from collections import deque

input = lambda : sys.stdin.readline().strip()

q = deque(input())

cnt = 0
while q:
    cnt += 1

    for i in range(len(str(cnt))):
        if q and str(cnt)[i] == q[0]:
            q.popleft()

print(cnt)