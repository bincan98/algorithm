"""
에라모르겠다로 냅다 소수를 구해??

8의 자리는 너무 큼

그냥 숫자에 하나씩 더하면서
그게 소수인지만 체크하자

예를 들어 빈 문자열에 7을 넣으면서 7이 소수인지 체크
7 옆에 1을 붙이면서 71이 소수인지 체크 이런식으로 해서
cur == N이면 출력하기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())


def check_prime(string):
    if int(string) == 1:
        return False
    for i in range(2, int(int(string) ** 0.5)+1):
        if int(string) % i == 0:
            return False
    return True


def recur(cur, string):
    if string != "":
        if not check_prime(string):
            return
    if cur == N:
        print(string)
        return
    for i in range(1, 10):
        recur(cur + 1, string + str(i))


recur(0, "")