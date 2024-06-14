"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

s = list(input())

lst = [False] * 5

for a in s:
    if a == 'M':
        lst[0] = True
    elif a == 'O':
        lst[1] = True
    elif a == 'B':
        lst[2] = True
    elif a == 'I':
        lst[3] = True
    elif a == 'S':
        lst[4] = True

answer = 'YES'
for a in lst:
    if not a:
        answer = 'NO'
        break

print(answer)