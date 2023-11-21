"""
deque 로 냅다 구현

한 위치에오면 반드시 다음에 갈 위치가 정해진다
그리고 이걸 그려보면 사이클이 나온다

만약 사이클에오면 횟수 나누기 ㄱㄱ
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

X = int(input())
origin = deque(input())

s = origin

cnt = -1
for i in range(1, X+1):
    pre = deque([])
    post = deque([])
    for j in range(len(s)):
        if j % 2 == 0:
            pre.append(s[j])
        else:
            post.appendleft(s[j])
    s = pre + post
    if s == origin:
        cnt = i
        break
if cnt != -1:
    for i in range(X % cnt):
        pre = deque([])
        post = deque([])
        for j in range(len(s)):
            if j % 2 == 0:
                pre.append(s[j])
            else:
                post.appendleft(s[j])
        s = pre + post

print("".join(s))