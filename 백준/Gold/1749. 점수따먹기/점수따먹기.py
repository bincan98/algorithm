"""
구간합 구하기 5와 비슷한 문제

2차원 누적합을 구해두자

그리고 2차원 누적최소를 구하고

각 좌표에서 누적합- 누적최소를 answer 에 넣어두자
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

# 입력 받을 배열, 누적합, 누적최소 배열 초기화
board = [[0 for _ in range(M+1)]]
prefix_sum = [[0] * (M+1) for _ in range(N+1)]

# 입력 받기
for i in range(N):
    board.append([0] + list(map(int, input().split())))

# 행으로 누적합 구하기
for i in range(1, N+1):
    for j in range(1, M+1):
        prefix_sum[i][j] = prefix_sum[i][j-1] + board[i][j]

# 열로 누적합 구하기
for j in range(1, M+1):
    for i in range(1, N+1):
        prefix_sum[i][j] += prefix_sum[i-1][j]

answer = -10_000
# 좌표 전부 돌면서 누적합 - 누적최소 answer 에 넣어보기
for i in range(1, N+1):
    for j in range(1, M+1):
        for k in range(1, i+1):
            for l in range(1, j+1):
                answer = max(answer, prefix_sum[i][j] - prefix_sum[k-1][j] - prefix_sum[i][l-1] + prefix_sum[k-1][l-1])

print(answer)