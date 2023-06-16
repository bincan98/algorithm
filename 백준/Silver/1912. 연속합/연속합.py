"""
구간 get 문제

누적합으로 점 get 으로 바꾸자

구간이 정해지지 않았고 n이 100,000이라 무작정 누적합을 반복하면 시간초과 날듯

역시 시간 초과..

가장 큰 연속 수열을 구하려면 한 누적합에서 앞의 누적합 중 가장 작은걸 빼야한다

그럼 누적합에 대해 prefix_sum 을 만들어보자
 
그리고 그걸 빼면 될듯
"""

import sys

input = sys.stdin.readline

n = int(input())

lst = [0] + list(map(int, input().split()))

prefix_sum = [0] * (n+1)

prefix_min = [0] * (n+1)

for i in range(1, n+1):
    prefix_sum[i] = prefix_sum[i-1] + lst[i]

for i in range(1, n+1):
    prefix_min[i] = min(prefix_min[i-1], prefix_sum[i])

# print(*prefix_sum)
# print(*prefix_min)

answer = -1000

for i in range(1, n+1):
    answer = max(answer, prefix_sum[i] - prefix_min[i-1])

print(answer)