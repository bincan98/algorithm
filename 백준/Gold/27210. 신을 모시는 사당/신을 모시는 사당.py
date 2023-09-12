"""
1과 2의 누적 차이를 배열에 저장해두고

prefix_min 과 prefix_max 를 두해둔다

그리고 누적차이와 prefix 배열들의 차의 max를 구하자
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

ls = [0] + list(map(int, input().split()))

prefix_sub = [0] * (N+1)

for i in range(1, N + 1):
    if ls[i] == 1:
        prefix_sub[i] = prefix_sub[i-1] - 1
    else:
        prefix_sub[i] = prefix_sub[i-1] + 1

prefix_max = [0] * (N+1)
prefix_min = [0] * (N+1)

for i in range(1, N+1):
    prefix_max[i] = max(prefix_max[i-1], prefix_sub[i])
    prefix_min[i] = min(prefix_min[i-1], prefix_sub[i])

answer = 0
for i in range(1, N+1):
    answer = max(answer, abs(prefix_sub[i] - prefix_min[i]))
    answer = max(answer, abs(prefix_sub[i] - prefix_max[i]))

print(answer)