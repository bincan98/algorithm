"""
완전탐색 & 구현

틀림

board 값 오염
"""
import sys

input = lambda: sys.stdin.readline().strip()


def pro(a):
    if a == 0: # 위로
        for c in range(N):
            pre = 0
            pointer = 0
            for r in range(N):
                if new_board[r][c] == 0:
                    continue
                if pre == 0:
                    pre = new_board[r][c]
                    continue
                if pre == new_board[r][c]:
                    tmp_board[pointer][c] = pre + new_board[r][c]
                    pointer += 1
                    pre = 0
                else:
                    tmp_board[pointer][c] = pre
                    pointer += 1
                    pre = new_board[r][c]
            if pre:
                tmp_board[pointer][c] = pre
    elif a == 1: # 아래로
        for c in range(N):
            pre = 0
            pointer = N - 1
            for r in range(N)[::-1]:
                if new_board[r][c] == 0:
                    continue
                if pre == 0:
                    pre = new_board[r][c]
                    continue
                if pre == new_board[r][c]:
                    tmp_board[pointer][c] = pre + new_board[r][c]
                    pointer -= 1
                    pre = 0
                else:
                    tmp_board[pointer][c] = pre
                    pointer -= 1
                    pre = new_board[r][c]
            if pre:
                tmp_board[pointer][c] = pre
    elif a == 2: # 왼쪽으로
        for r in range(N):
            pre = 0
            pointer = 0
            for c in range(N):
                if new_board[r][c] == 0:
                    continue
                if pre == 0:
                    pre = new_board[r][c]
                    continue
                if pre == new_board[r][c]:
                    tmp_board[r][pointer] = pre + new_board[r][c]
                    pointer += 1
                    pre = 0
                else:
                    tmp_board[r][pointer] = pre
                    pointer += 1
                    pre = new_board[r][c]
            if pre:
                tmp_board[r][pointer] = pre
    else: # 오른쪽으로
        for r in range(N):
            pre = 0
            pointer = N - 1
            for c in range(N)[::-1]:
                if new_board[r][c] == 0:
                    continue
                if pre == 0:
                    pre = new_board[r][c]
                    continue
                if pre == new_board[r][c]:
                    tmp_board[r][pointer] = pre + new_board[r][c]
                    pointer -= 1
                    pre = 0
                else:
                    tmp_board[r][pointer] = pre
                    pointer -= 1
                    pre = new_board[r][c]
            if pre:
                tmp_board[r][pointer] = pre


def recur(cur):
    if cur == 5:
        global answer
        global new_board
        global tmp_board
        for i in range(N):
            for j in range(N):
                new_board[i][j] = board[i][j]
        for a in selected:
            tmp_board = [[0 for _ in range(N)] for _ in range(N)]
            pro(a)
            for i in range(N):
                for j in range(N):
                    new_board[i][j] = tmp_board[i][j]
        for i in range(N):
            answer = max(answer, max(new_board[i]))
        return
    for i in range(4):
        selected[cur] = i
        recur(cur + 1)


N = int(input())

board = []
new_board = [[0 for _ in range(N)] for _ in range(N)]
tmp_board = [[0 for _ in range(N)] for _ in range(N)]
for _ in range(N):
    board.append(list(map(int, input().split())))

answer = 0
selected = [0] * 5
recur(0)

print(answer)