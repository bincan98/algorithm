"""
수들의 합 4 랑 같다

두 배열을 서로 뺴고 0이 되는지 체크하기
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N = int(input())

ls_a = [0] + list(map(int, input().split()))
ls_b = [0] + list(map(int, input().split()))

prefix_sum = [0] * (N+1)
int_dict = defaultdict(int)

for i in range(1, N+1):
    prefix_sum[i] = prefix_sum[i-1] + (ls_a[i] - ls_b[i])

answer = 0
for i in range(1, N+1):
    if prefix_sum[i] == 0:
        answer += 1
    answer += int_dict[prefix_sum[i]]
    int_dict[prefix_sum[i]] += 1

print(answer)