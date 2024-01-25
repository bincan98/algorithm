"""
자른 나무를 또 자르는 걸 비효율적이다 마지막에 자르면 되니까
또 자라는 양이 제일 많은 나무를 늦게 잘라야 효율이 좋다
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))
delta = list(map(int, input().split()))

answer = 0
for a in lst:
    answer += a

delta = sorted(delta)
for i in range(N):
    answer += delta[i] * i

print(answer)