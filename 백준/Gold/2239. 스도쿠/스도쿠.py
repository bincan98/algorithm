"""
빈 공간에 1부터 9까지 넣어보면서 완탐하기 이미 있는 수라면 가지치기

시간초과

1부터 9까지 모든 수를 넣지 말고 후보수를 추려서 넣자

시간초과

check 배열을 만들지 않고 lst[i][j]를 들고가서 같은지 비교하기
매번 새로 배열을 만드는게 부담인듯?

참고
https://ji-gwang.tistory.com/377
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = []
for _ in range(9):
    lst.append(list(map(int, input())))

zero_position = []
possible_row = [[False for _ in range(10)] for _ in range(9)]
possible_column = [[False for _ in range(10)] for _ in range(9)]
for i in range(9):
    for j in range(9):
        if lst[i][j] == 0:
            zero_position.append([i, j])
        else:
            possible_row[i][lst[i][j]] = True
            possible_column[j][lst[i][j]] = True


def check_row(r, num):
    for j in range(9):
        if lst[r][j] == num:
            return False
    return True


def check_column(c, num):
    for i in range(9):
        if lst[i][c] == num:
            return False
    return True


def check_box(r, c, num):
    nr = r // 3 * 3
    nc = c // 3 * 3
    for i in range(3):
        for j in range(3):
            if lst[nr + i][nc + j] == num:
                return False
    return True


def recur(cur):
    if cur == len(zero_position):
        for a in range(9):
            for b in range(9):
                print(lst[a][b], end="")
            print()
        exit()
        return
    r, c = zero_position[cur][0], zero_position[cur][1]
    for i in range(1, 10):
        if possible_row[r][i]:
            continue
        if possible_column[c][i]:
            continue
        if check_row(r, i) and check_column(c, i) and check_box(r, c, i):
            lst[r][c] = i
            recur(cur + 1)
            lst[r][c] = 0


recur(0)