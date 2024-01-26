"""
빈 공간에 1부터 9까지 넣어보면서 완탐하기 이미 있는 수라면 가지치기

시간초과

1부터 9까지 모든 수를 넣지 말고 후보수를 추려서 넣자
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = []
for _ in range(9):
    lst.append(list(map(int, input())))

zero_position = []
possible_row = [[False for _ in range(10)] for _ in range(9)]
possible_column = [[False for _ in range(10)] for _ in range(9)]
possible_box = [[False for _ in range(10)] for _ in range(9)]
for i in range(9):
    for j in range(9):
        if lst[i][j] == 0:
            zero_position.append([i, j])
        else:
            possible_row[i][lst[i][j]] = True
            possible_column[j][lst[i][j]] = True


def check_row(r, c, num):
    for j in range(9):
        if c != j and lst[r][j] == num:
            return False
    return True


def check_column(r, c, num):
    for i in range(9):
        if r != i and lst[i][c] == num:
            return False
    return True


def check_box(r, c, num):
    nr = r // 3 * 3
    nc = c // 3 * 3
    for i in range(3):
        for j in range(3):
            if r != nr + i and c != nc + j and lst[nr + i][nc + j] == num:
                return False
    return True


def recur(cur, r, c, num):
    if cur != 0:
        if not check_row(r, c, num):
            return
        if not check_column(r, c, num):
            return
        if not check_box(r, c, num):
            return
    if cur == len(zero_position):
        for a in range(9):
            for b in range(9):
                print(lst[a][b], end="")
            print()
        exit()
        return
    for i in range(1, 10):
        if possible_row[zero_position[cur][0]][i]:
            continue
        if possible_column[zero_position[cur][1]][i]:
            continue
        lst[zero_position[cur][0]][zero_position[cur][1]] = i
        recur(cur + 1, zero_position[cur][0], zero_position[cur][1], i)
        lst[zero_position[cur][0]][zero_position[cur][1]] = 0


recur(0, 0, 0, 0)
