"""
A 배열의 원소가 1000개 이므로 가능한 모든 부 배열의 합은 1,000,000개이다

A와 B의 모든 부 배열의 합을 구해놓고 투포인터로 풀자
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

T = int(input())
N = int(input())
ls_a = [0] + list(map(int, input().split()))
M = int(input())
ls_b = [0] + list(map(int, input().split()))

prefix_a_sum = [0] * (N+1)
prefix_b_sum = [0] * (M+1)

for i in range(N+1):
    prefix_a_sum[i] = prefix_a_sum[i-1] + ls_a[i]

for i in range(M+1):
    prefix_b_sum[i] = prefix_b_sum[i-1] + ls_b[i]

sub_a = []
sub_b = []
sub_a_dict = defaultdict(int)
sub_b_dict = defaultdict(int)

for i in range(1, N+1):
    for j in range(0, i):
        result = prefix_a_sum[i] - prefix_a_sum[j]
        if sub_a_dict[result] == 0:
            sub_a.append(result)
        sub_a_dict[result] += 1


for i in range(1, M+1):
    for j in range(0, i):
        result = prefix_b_sum[i] - prefix_b_sum[j]
        if sub_b_dict[result] == 0:
            sub_b.append(result)
        sub_b_dict[result] += 1

sub_a = sorted(sub_a)
sub_b = sorted(sub_b)

# print(sub_a)
# print(sub_b)

start = 0
end = len(sub_b) - 1

answer = 0
while start != len(sub_a) and end != -1:
    sum_value = sub_a[start] + sub_b[end]
    if sum_value < T:
        start += 1
    elif sum_value > T:
        end -= 1
    else:
        answer += sub_a_dict[sub_a[start]] * sub_b_dict[sub_b[end]]
        start += 1
        end -= 1

print(answer)