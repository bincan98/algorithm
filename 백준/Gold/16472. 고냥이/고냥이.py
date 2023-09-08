"""
조건을 만족하는 연속구간 투포인터로 풀어보자

start = 0, end = 0

새로 문자를 넣을때마다 dict에 넣기
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N = int(input())

s = input()

dict = defaultdict(int)

start = 0
end = 0
dict[s[end]] += 1

answer = 0
while start <= end:
    if len(dict) <= N:
        answer = max(answer, end - start + 1)
        end += 1
        if end == len(s):
            break
        dict[s[end]] += 1
    else:
        dict[s[start]] -= 1
        if dict[s[start]] == 0:
            del dict[s[start]]
        start += 1

print(answer)