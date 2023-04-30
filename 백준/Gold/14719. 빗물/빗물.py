import sys
input = sys.stdin.readline

H, W = map(int, input().split())
lst = [0] + list(map(int, input().split())) + [0]

prefix_max = [0] * (W+2)
suffix_max = [0] * (W+2)

for i in range(1, W+1):
    prefix_max[i] = max(prefix_max[i-1], lst[i])

for i in range(W, 0, -1):
    suffix_max[i] = max(suffix_max[i+1], lst[i])

answer = 0
for i in range(W):
    answer += min(prefix_max[i], suffix_max[i]) - lst[i]

print(answer)