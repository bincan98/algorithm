import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = dict()

answer = 0
for i in range(N):
    a, b = map(int, input().split())
    if a in lst and lst[a] != b:
        lst[a] = b
        answer += 1
    else:
        lst[a] = b

print(answer)