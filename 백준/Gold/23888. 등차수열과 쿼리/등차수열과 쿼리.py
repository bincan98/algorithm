"""
1은 등차수열의 합 공식 사용

2는 유탁쌤의 최대공약수 수업에 답이 있음

A < B일때
A와 B의 최대공약수 == A와 (B - A)의 최대공약수인걸 이용
그럼 l부터 r까지의 최대 공약수는 모두 l의 값과 d의 최대공약수와 같다
"""

import sys

input = lambda: sys.stdin.readline().strip()

a, d = map(int, input().split())


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


for i in range(int(input())):
    op, l, r = map(int, input().split())
    if op == 1:
        print((r - l + 1) * (a + (l - 1) * d + a + (r - 1) * d) // 2)
    else:
        x = a + (l - 1) * d
        y = d
        if l == r or d == 0:
            print(x)
        else:
            if x < y:
                x, y = y, x
            print(gcd(x, y))