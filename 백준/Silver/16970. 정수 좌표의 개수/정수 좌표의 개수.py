"""
정수론

백준 2725
보이는 점의 개수 문제와 비슷

두 점에서 y값의 차와 x값의 차 끼리 gcd 구하기

나온 gcd + 1d이 선분이 지나가면서 지나는 정수 좌표의 개수
"""
import sys

input = lambda: sys.stdin.readline().strip()


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


N, M, K = map(int, input().split())

cnt = 0
for x1 in range(N + 1):
    for y1 in range(M + 1):
        for x2 in range(N + 1):
            for y2 in range(M + 1):
                if x1 == x2 and y1 == y2:
                    continue
                a = abs(x1 - x2)
                b = abs(y1 - y2)
                if b > a:
                    a, b = b, a
                if b == 0: # x축이나 y축에 평행하는 경우
                    if a + 1 == K:
                        cnt += 1
                else:
                    if gcd(a, b) + 1 == K:
                        cnt += 1

# 선분이 두개씩 들어가므로 2로 나누기
print(cnt//2)