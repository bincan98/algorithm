import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

lst = deque(list(map(int, input().split(','))))

for i in range(K):
    for j in range(len(lst) - 1):
        lst.append(-lst.popleft() + lst[0])
    lst.popleft()

s = ""
for i in range(len(lst)):
    s += str(lst[i])
    s += ","

print(s[0:-1])