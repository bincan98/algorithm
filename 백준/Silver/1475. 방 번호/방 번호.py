"""
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

lst = list(input())

dic = defaultdict(int)
for ele in lst:
    dic[ele] += 1

answer = 0
for i in dic:
    if i == '6' or i == '9':
        continue
    answer = max(answer, dic[i])

answer = max(answer, int((dic['6'] + dic['9']) / 2 + 0.5))

print(answer)