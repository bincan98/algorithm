"""
백트래킹

비숍을 놓기전에 가능한지 살펴보자

시간초과

체스판의 검은색과 희색은 어차피 서로 잡지 못하니까 나눠서 최대값을 구하자
"""
import sys

input = lambda: sys.stdin.readline().strip()

dxy = [[-1, -1], [-1, 1], [1, 1], [1, -1]]

N = int(input())
lst = []
for _ in range(N):
    lst.append(list(map(int, input().split())))

possible_position = [[], []]
for i in range(N):
    for j in range(N):
        if lst[i][j] == 1:
            if abs(i + j) % 2 == 0:
                possible_position[0].append([i, j])
            else:
                possible_position[1].append([i, j])


def check(r, c):
    for dx, dy in dxy:
        for i in range(1, N+1):
            ny = r + dy * i
            nx = c + dx * i
            if 0 > ny or N <= ny or 0 > nx or N <= nx:
                break
            if lst[ny][nx] == 2:
                return False
    return True


def recur(cur, cnt, color):
    if cur == len(possible_position[color]):
        if color == 0:
            global answer1
            answer1 = max(answer1, cnt)
        else:
            global answer2
            answer2 = max(answer2, cnt)
        # for i in range(N):
        #     print(*lst[i])
        return
    nr, nc = possible_position[color][cur][0], possible_position[color][cur][1]
    if check(nr, nc):
        lst[nr][nc] = 2
        recur(cur + 1, cnt + 1, color)
    lst[nr][nc] = 1
    recur(cur + 1, cnt, color)


answer1 = 0
recur(0, 0, 0)
answer2 = 0
recur(0, 0, 1)
print(answer1 + answer2)