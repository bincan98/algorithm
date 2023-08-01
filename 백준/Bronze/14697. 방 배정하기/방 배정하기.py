"""
완전탐색

가능한 경우의 수를 모두 체크해서 가능하지 검사해보자

A, B, C 중에 1이 있다면 모든 경우의 수가 가능

최소 2부텉 시작하면 어떤 한 방의 최대 사용가능한 수는 150이다.

A, B, C의 배정되는 방의 수를 각각 i, j, k라 두면 최대 150이다.

A * i + B * j + C * k == N 이라면 가능한 경우이다.

150을 최적화 해보자
"""

import sys

input = lambda: sys.stdin.readline().strip()

A, B, C, N = map(int, input().split())

answer = 0
for i in range(N // A + 1):
    for j in range(N // B + 1):
        for k in range(N // C + 1):
            if A * i + B * j + C * k == N:
                answer = 1

print(answer)