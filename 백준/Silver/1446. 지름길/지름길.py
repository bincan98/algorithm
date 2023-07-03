"""
완탐해보자면 N이 6이라면
6
5 + (1)
4 + (2)
3 + (3 (2 + 1))
식으로

하나씩 내려가면서 구하면 될듯하다
(N+1) // 2 까지

그리고 계속 반복되므로 memoization 해두자

dp[i]는 i 를 서로 다른 자연수의 합으로 나타내는 방법의 수를 100999로 나눈 나머지 이다
dp[1] = 1
dp[2] = 1
dp[3] = 2
dp[4] = 2

예외처리할 부분:
dp[4]에서 i 가 2일때
dp[2]는 2 이므로 dp[4]에 1을 추가할테지만
실제로 dp[2]는 2일떄 이므로
2 + 2인 경우이다.
따라서 이런경우는 제외해야 맞다
만약 i == N - i 라면
dp[N-i]에서는 1을 빼고 더해주어야 한
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, D = map(int, input().split())

shortcuts = []
for i in range(N):
    shortcuts.append(list(map(int, input().split())))

shortcuts = sorted(shortcuts)

answer = D


def recur(index, end, distance):
    if end > D:
        return
    global answer
    answer = min(answer, distance + (D - end))
    for i in range(index + 1, len(shortcuts)):
        if end > shortcuts[i][0]:
            continue
        recur(i, shortcuts[i][1], distance + (shortcuts[i][0] - end) + shortcuts[i][2])


for i in range(len(shortcuts)):
    recur(i, shortcuts[i][1], shortcuts[i][2] + shortcuts[i][0])

print(answer)