import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

q = deque()
for _ in range(int(input())):
    lst = list(input().split())
    if lst[0] == "push":
        q.append(int(lst[1]))
    elif lst[0] == "pop":
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())
    elif lst[0] == "size":
        print(len(q))
    elif lst[0] == "empty":
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif lst[0] == "front":
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif lst[0] == "back":
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])