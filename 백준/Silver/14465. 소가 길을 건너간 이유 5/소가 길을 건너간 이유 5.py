"""
1 2 3 4 5 6 7 8 9 10
x x     x       x x

슬라이딩 윈도우 문제이다

한 슬라이딩 윈도우에 고장난 신호등이 몇개인지 체크하고 최소값을 구하는 것
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, K, B = map(int, input().split())

# 신호등 저장할 배열
lst = [True] * (N+1)

# 고장난 신호등 입력받기
for _ in range(B):
    lst[int(input())] = False

answer = 100_000
result = 0
# 첫 슬라이딩 윈도우 체크하기
for i in range(1, K+1):
    if not lst[i]:
        result += 1

# answer 에 넣어보기
answer = min(answer, result)

for i in range(2, N-K+2):
    # 앞부분 빼기
    if not lst[i-1]:
        result -= 1
    # 뒤부분 넣기
    if not lst[i+K-1]:
        result += 1
    # answer 에 넣어보기
    answer = min(answer, result)

print(answer)