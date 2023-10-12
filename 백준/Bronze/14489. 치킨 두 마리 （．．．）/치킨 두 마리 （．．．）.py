"""
냅다 bfs 까지는 아니고..
지금 칸보다 작으면 앞으로 갈꺼니까 사이클이 발생할 가능성은 없다
그리고 다음칸에 경우의수 + 1

근데 왜 시간초과 ?
"""
import sys
from collections import deque

dxy = [[0, 1], [1, 0], [0, -1], [-1, 0]]

input = lambda: sys.stdin.readline().strip()

A, B = map(int, input().split())
C = int(input())

if A + B >= 2 * C:
    print(A + B - 2 * C)
else:
    print(A + B)