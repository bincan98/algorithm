import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

diff = [-1] * N
tmp = lst[-1]
for i in range(N-1)[::-1]:
    if tmp == lst[i]:
        diff[i] = diff[i+1]
    else:
        diff[i] = i + 2
        tmp = lst[i]

print(*diff)