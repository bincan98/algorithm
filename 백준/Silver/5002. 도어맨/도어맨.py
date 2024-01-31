"""
그리디
차이를 기억하고 이번에 차이를 넘는다면 자리를 바꿔주기
그럼에도 차이를 넘으면 그만하기

틀림
반례
1
MM
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

X = int(input())
s = deque(list(input()))

diff = 0
i = 0
while True:
    if abs(diff) > X:
        i -= 1
        break
    if len(s) == 0:
        break
    elif abs(diff) < X:
        if s[0] == "M":
            diff += 1
        else:
            diff -= 1
        s.popleft()
    else: # abs(diff) == X:
        if len(s) == 1:
            if s[0] == "M":
                diff += 1
            else:
                diff -= 1
            s.popleft()
        else:
            if diff > 0 and s[0] == "M":
                s[0], s[1] = s[1], s[0]
            elif diff < 0 and s[0] == "W":
                s[0], s[1] = s[1], s[0]
            if s[0] == "M":
                diff += 1
            else:
                diff -= 1
            s.popleft()
    i += 1
print(i)