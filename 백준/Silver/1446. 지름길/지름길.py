"""
완탐하고 백트래킹
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, D = map(int, input().split())

shortcuts = []
for i in range(N):
    shortcuts.append(list(map(int, input().split())))

shortcuts = sorted(shortcuts)

answer = D


def recur(index, end, distance):
    if end > D:
        return
    global answer
    answer = min(answer, distance + (D - end))
    for i in range(index + 1, len(shortcuts)):
        if end > shortcuts[i][0]:
            continue
        recur(i, shortcuts[i][1], distance + (shortcuts[i][0] - end) + shortcuts[i][2])


for i in range(len(shortcuts)):
    recur(i, shortcuts[i][1], shortcuts[i][2] + shortcuts[i][0])

print(answer)
