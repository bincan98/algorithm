import sys

input = sys.stdin.readline

N, K = map(int, input().split())
arr = [0] + list(map(int, input().split()))

sum = 0
for i in range(K+1):
    sum += arr[i]

answer = sum

for i in range(1, N-K+1):
    sum -= arr[i]
    sum += arr[i+K]
    answer = max(answer, sum)

print(answer)