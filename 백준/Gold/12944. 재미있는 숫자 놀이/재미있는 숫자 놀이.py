"""
N을 k의 원소들로 나누면 개수들을 구할 수 있지만 최소공배수의 수만큼 겹친다

이걸 처리하기

부분집합으로 lcm할 것 구하기

lcm 한 개수가 홀수라면 answer에 +해주고
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