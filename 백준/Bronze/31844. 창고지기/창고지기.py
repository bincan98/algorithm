"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = list(input())

is_possible = False
is_start = False
answer = 0
for a in lst:
    if not is_start and (a == '@' or a == '!'):
        is_start = True
    elif is_start and (a == '@' or a == '!'):
        break
    elif not is_start and a == '#':
        continue
    elif not is_start and a == '.':
        continue
    elif is_start and a == '#':
        answer += 1
        is_possible = True
    elif is_start and a == '.':
        answer += 1

if is_possible:
    print(answer)
else:
    print(-1)