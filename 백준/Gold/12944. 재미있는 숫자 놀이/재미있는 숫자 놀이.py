"""
부분집합으로 gcd할것 구하기

gcd 한 개수가 홀수라면 +해주고
짝수라면 -해주기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())
lst = list(map(int, input().split()))
lst = sorted(lst)

selected = [False] * K


def gcd(a, b):
    if a < b:
        a, b = b, a
    while a % b:
        a, b = b, a % b
    return b


def recur(cur, total):
    if cur == K:
        global answer
        if total == 0:
            return
        lcm = 1
        for i in range(K):
            if selected[i]:
                lcm = lcm * lst[i] // gcd(lcm, lst[i])
        if total % 2 == 0:
            answer -= (N // lcm)
        else:
            answer += (N // lcm)
        return
    selected[cur] = False
    recur(cur + 1, total)
    selected[cur] = True
    recur(cur + 1, total + 1)


answer = 0
recur(0, 0)

print(answer)