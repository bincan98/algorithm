"""
정수론

어떤수 N을 2로 나누면 2르 소인수로 가지고 있는 수들의 개수를 구할 수 있다

그리고 8을 소인수로 가지고 있다면 4도 약수로 가지고 있는 것

8을 소인수로 가지고 있는 수들의 개수를 구하면 그만큼 4를 빼주고 8을 더해준다
"""
import sys

input = lambda: sys.stdin.readline().strip()

A, B = map(int, input().split())


def pro(x):
    result = x
    sq_2 = 2
    while sq_2 <= x:
        cnt = x // sq_2
        result += (cnt * (sq_2 - (sq_2 // 2)))
        sq_2 *= 2
    return result


print(pro(B) - pro(A - 1))