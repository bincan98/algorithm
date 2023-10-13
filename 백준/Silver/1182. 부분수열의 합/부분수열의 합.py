"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, S = map(int, input().split())
lst = list(map(int, input().split()))


def recur(cur, total):
    if cur == N:
        if total == S:
            global answer
            answer += 1
        return
    recur(cur + 1, total + lst[cur])
    recur(cur + 1, total)


answer = 0
recur(0, 0)
if S == 0:
    print(answer - 1)
else:
    print(answer)