"""
구간합 구하기 5와 비슷한 문제

각 칸마다 [0 ~ 10]의 배열을 만들어 두고 개수를 체크하자

그리고 (1, 1) 부터 각 칸까지의 [0 ~ 10]의 배열 누적개수를 만들어 두자

원본 배열이 바뀌는 걸 주의
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

# 각 칸마다 [0 ~ 10]의 배열을 만들어 두기
board = [[[0 for _ in range(11)] for _ in range(N+1)] for _ in range(N+1)]

# 입력 받은 배열대로 개수에 체크해두기
for i in range(1, N+1):
    lst = [0] + list(map(int, input().split()))
    for j in range(1, N+1):
        board[i][j][lst[j]] += 1

# 행으로 누적개수 구하기
for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(11):
            board[i][j][k] += board[i][j-1][k]

# 열로 누적개수 구하기
for j in range(1, N+1):
    for i in range(1, N+1):
        for k in range(11):
            board[i][j][k] += board[i-1][j][k]

Q = int(input())
# 쿼리 진행
for _ in range(Q):
    x1, y1, x2, y2 = map(int, input().split())

    # (1, 1)부터 (x2, y2)까지 배열 가져오기
    # 배열을 잘못 가져오면 원본 값이 바뀐다
    arr = board[x2][y2][:]

    # (1, 1)부터 (x1-1, y2)까지 누적개수를 arr 에서 빼주기
    for i in range(11):
        arr[i] -= board[x1-1][y2][i]

    # (1, 1)부터 (x2, y1-1)까지 누적개수를 arr 에서 빼주기
    for i in range(11):
        arr[i] -= board[x2][y1-1][i]

    # (1, 1)부터 (x1-1, y1-1)까지 누적개수를 arr 에 다시 더해주기
    for i in range(11):
        arr[i] += board[x1-1][y1-1][i]

    answer = 0
    # 서로 다른 정수 개수 구하기
    for i in range(11):
        if arr[i] > 0:
            answer += 1

    print(answer)