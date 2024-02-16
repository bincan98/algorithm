"""
4^10 = 2^20 = 10^6

완탐 가능

상하좌우 모든 경우의 수를 담은 배열을 만들고 돌려보면서 찾기

proc == 구슬 굴리기 함수
up이면 구슬부터 올라가서 위치를 찾으면 됨

그럼 어차피 보드에서 각 위치가 갈 수 있는 위치는 정해짐 그걸 찾아두자

틀림
N만큼 뻗어가면서 탐색하기로 했는데 만약 M이 더 길다면!!!!!
N과 M중에 더 긴걸로 하장
"""
import sys

input = lambda: sys.stdin.readline().strip()


def proc(d, red_position, blue_position): # 0: 갱신 완료 1: 성공 2: 실패
    red_y, red_x = red_position
    blue_y, blue_x = blue_position
    next_red_y, next_red_x = next_position[red_y][red_x][d]
    next_blue_y, next_blue_x = next_position[blue_y][blue_x][d]
    if next_blue_y == 20:
        return 2, [], []
    elif next_red_y == 20:
        return 1, [], []
    if next_red_y == next_blue_y and next_red_x == next_blue_x:
        if d == 0:
            if red_y > blue_y:
                next_red_y += 1
            else:
                next_blue_y += 1
        elif d == 1:
            if red_x > blue_x:
                next_blue_x -= 1
            else:
                next_red_x -= 1
        elif d == 2:
            if red_y > blue_y:
                next_blue_y -= 1
            else:
                next_red_y -= 1
        elif d == 3:
            if red_x > blue_x:
                next_red_x += 1
            else:
                next_blue_x += 1
    return 0, [next_red_y, next_red_x], [next_blue_y, next_blue_x]


def recur(cur, red_position, blue_position, history):
    global answer
    if cur == 10 or cur + 1 >= answer:
        return
    for i, d in [[0, 'U'], [1, 'R'], [2, 'D'], [3, 'L']]:
        result, next_red_position, next_blue_position = proc(i, red_position, blue_position)
        if result == 1:
            if answer > cur + 1:
                global answer_lst
                answer = cur + 1
                answer_lst = history + [d]
            return
        elif result == 2:
            continue
        recur(cur + 1, next_red_position, next_blue_position, history + [d])


N, M = map(int, input().split())
lst = []
for _ in range(N):
    lst.append(list(input()))

next_position = [[[[-1 for _ in range(2)] for _ in range(4)] for _ in range(M)] for _ in range(N)]
ori_red_y = -1
ori_red_x = -1
ori_blue_y = -1
ori_blue_x = -1
for i in range(1, N - 1):
    for j in range(1, M - 1):
        if lst[i][j] == 'R':
            ori_red_y = i
            ori_red_x = j
        elif lst[i][j] == 'B':
            ori_blue_y = i
            ori_blue_x = j
        # 위치 찾아두기
        for dy, dx, d in [[-1, 0, 0], [0, 1, 1], [1, 0, 2], [0, -1, 3]]: # 상 우 하 좌
            for k in range(max(N, M)):
                ny = i + dy * k
                nx = j + dx * k
                if 0 <= ny < N and 0 <= nx < M:
                    if lst[ny][nx] == 'O':
                        next_position[i][j][d] = [20, 20] # 골인인 경우
                        break
                    elif lst[ny][nx] != '#':
                        next_position[i][j][d] = [ny, nx]
                    else:
                        break

answer = 20
answer_lst = []
recur(0, [ori_red_y, ori_red_x], [ori_blue_y, ori_blue_x], [])

if answer != 20:
    print(answer)
    print(''.join(answer_lst))
else:
    print(-1)