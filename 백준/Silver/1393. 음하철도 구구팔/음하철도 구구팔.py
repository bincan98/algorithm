"""
직선방정식을 이용

틀림

https://www.acmicpc.net/board/view/66201
"""
import sys

input = lambda: sys.stdin.readline().strip()


def gcd(a, b):
    if a < b:
        a, b = b, a
    while a % b:
        a, b = b, a % b
    return b


xs, ys = map(int, input().split())
xe, ye, dx, dy = map(int, input().split())

if dx == 0 and dy != 0:
    dy = 1
elif dy == 0 and dx != 0:
    dx = 1
else:
    GCD = gcd(dx, dy)
    dx //= GCD
    dy //= GCD

min_distance = ((xs - xe) ** 2 + (ys - ye) ** 2) ** 0.5
answer_X = xe
answer_Y = ye
while True:
    xe += dx
    ye += dy
    if min_distance >= ((xs - xe) ** 2 + (ys - ye) ** 2) ** 0.5:
        min_distance = ((xs - xe) ** 2 + (ys - ye) ** 2) ** 0.5
        answer_X = xe
        answer_Y = ye
    else:
        break

print(answer_X, answer_Y)