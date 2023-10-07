"""

"""

import sys

input = lambda: sys.stdin.readline().strip()

lst1 = []
lst2 = []

N = int(input())
for i in range(N):
    a, b = map(int, input().split())
    lst1.append(a)
    lst2.append(b)

lst1 = sorted(lst1)
lst2 = sorted(lst2)

x = lst1[(N+1)//2-1]
y = lst2[(N+1)//2-1]

answer = 0
for i in range(N):
    answer += abs(x - lst1[i])
    answer += abs(y - lst2[i])

print(answer)