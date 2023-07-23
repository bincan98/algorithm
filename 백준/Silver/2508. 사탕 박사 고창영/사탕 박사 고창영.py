"""
완전탐색

o를 찾는다면 왼쪽에서 > 오른쪽에서 <
위쪽에서 ^ 아래쪽에서 v가 있는지 확인하기
"""

import sys

input = lambda: sys.stdin.readline().strip()

t = int(input())


def is_valid(y, x):
    return 0 <= y < r and 0 <= x < c


for _ in range(t):
    _ = input()
    r, c = map(int, input().split())
    lst = []
    answer = 0
    for i in range(r):
        lst.append(list(input()))

    for i in range(r):
        for j in range(c):
            if lst[i][j] == 'o':
                if is_valid(i, j - 1) and lst[i][j - 1] == '>':
                    if is_valid(i, j + 1) and lst[i][j + 1] == '<':
                        answer += 1
                if is_valid(i - 1, j) and lst[i - 1][j] == 'v':
                    if is_valid(i + 1, j) and lst[i + 1][j] == '^':
                        answer += 1

    print(answer)