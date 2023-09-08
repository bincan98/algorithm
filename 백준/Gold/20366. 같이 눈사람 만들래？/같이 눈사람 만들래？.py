"""
조건을 만족하는 두 수 투포인터
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

lst = sorted(lst)

answer = 10000000000
for i in range(N):
    for j in range(i + 1, N):
        sum_value = lst[i] + lst[j]
        start = 0
        end = N-1
        while start == i or start == j:
            start += 1
        while end == i or end == j:
            end -= 1
        while start < end:
            if (lst[start] + lst[end]) - sum_value < 0:
                answer = min(answer, abs((lst[start] + lst[end]) - sum_value))
                start += 1
                while start == i or start == j:
                    start += 1
            else:
                answer = min(answer, abs((lst[start] + lst[end]) - sum_value))
                end -= 1
                while end == i or end == j:
                    end -= 1

print(answer)