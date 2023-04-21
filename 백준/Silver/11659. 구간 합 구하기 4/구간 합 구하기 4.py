import sys

input = sys.stdin.readline

N, M = map(int, input().split())
lst = [0] + list(map(int, input().split()))

sum_lst = [0 for i in range(N+1)]

for i in range(N+1):
    sum_lst[i] = sum_lst[i-1] + lst[i]

for _ in range(M):
    a, b = map(int, input().split())
    print(sum_lst[b] - sum_lst[a-1])