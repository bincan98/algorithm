import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
lst = list(map(int, input().split()))

answer = abs(lst[0] - lst[1])
for i in range(n-1):
    answer = min(answer, abs(lst[i] - lst[i+1]))

print(answer)