"""
운영체제 알고리즘인디 SJF였나
암튼 짧은거 먼저 하기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

lst = sorted(lst)

answer = 0
for i in range(N):
    answer += lst[i] * (N - i)

print(answer)