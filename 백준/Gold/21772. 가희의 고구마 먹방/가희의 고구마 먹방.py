"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

dxy = [[0, 1], [1, 0], [0, -1], [-1, 0]]

R, C, T = map(int, input().split())

ls = []
for i in range(R):
    ls.append(list(input()))

start_y = -1
start_x = -1
for i in range(R):
    for j in range(C):
        if ls[i][j] == 'G':
            start_y = i
            start_x = j
            break


def recur(depth, cur_y, cur_x, goguma):
    if depth == T:
        global answer
        answer = max(answer, goguma)
        return
    for y, x in dxy:
        ny = cur_y + y
        nx = cur_x + x
        if 0 <= ny < R and 0 <= nx < C and ls[ny][nx] != '#':
            if ls[ny][nx] == 'S':
                ls[ny][nx] = 'X'
                recur(depth + 1, ny, nx, goguma + 1)
                ls[ny][nx] = 'S'
            else:
                recur(depth + 1, ny, nx, goguma)


answer = 0
recur(0, start_y, start_x, 0)
print(answer)