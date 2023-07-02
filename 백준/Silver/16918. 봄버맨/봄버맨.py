"""
일단 빡구현 해봅시더

폭탄이 터질때 주변 폭탄도 터지므로 새로운 보드를 만들어 놓아야한다
"""

import sys

input = lambda: sys.stdin.readline().strip()

dy = [0, -1, 0, 1]
dx = [-1, 0, 1, 0]

R, C, N = map(int, input().split())


def isValid(y, x):
    return 0 <= y < R and 0 <= x < C


board = [[['.', -10] for _ in range(C)] for _ in range(R)]
for i in range(R):
    lst = list(input())
    for j in range(C):
        if lst[j] == 'O':
            board[i][j] = ['O', 0]

for time in range(1, N+1):
    if time % 2 == 0:
        for i in range(R):
            for j in range(C):
                if board[i][j][0] == '.':
                    board[i][j][0] = 'O'
                    board[i][j][1] = time
    else:
        newBoard = [[['.', -10] for _ in range(C)] for _ in range(R)]
        for i in range(R):
            for j in range(C):
                for k in range(2):
                    newBoard[i][j][k] = board[i][j][k]
        for i in range(R):
            for j in range(C):
                if newBoard[i][j][0] == 'O' and newBoard[i][j][1] == time - 3:
                    board[i][j][0] = '.'
                    board[i][j][1] = -10
                    for k in range(4):
                        ny = i + dy[k]
                        nx = j + dx[k]
                        if isValid(ny, nx):
                            board[ny][nx][0] = '.'
                            board[ny][nx][1] = -10
    # print('---------------------------------------------')
    # print('time : ', time)
    # for i in range(R):
    #     for j in range(C):
    #         print(board[i][j], end='')
    #     print()
for i in range(R):
        for j in range(C):
            print(board[i][j][0], end='')
        print()