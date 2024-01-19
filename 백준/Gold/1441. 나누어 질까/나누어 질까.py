"""
https://www.acmicpc.net/problem/12944
문제와 비슷

2와 3이 주어지면
+ (R // 2) - ((L-1) // 2)
+ (R // 3) - ((L-1) // 3)
- (R // lcm(2, 3)) - ((L-1) // lcm(2,3))

lcm의 원소가 홀수라면 + 짝수개라면 -
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, L, R = map(int, input().split())
lst = list(map(int, input().split()))


def gcd(a, b):
    if a < b:
        a, b = b, a
    while a % b:
        a, b = b, a % b
    return b


def recur(cur, cnt):
    if cur == N:
        if cnt == 0:
            return
        global answer
        a = 1
        for i in range(N):
            if selected[i]:
                a = a * lst[i] // gcd(a, lst[i])
        if cnt % 2 == 0:
            answer -= (R // a) - ((L-1) // a)
        else:
            answer += (R // a) - ((L-1) // a)
        return
    selected[cur] = False
    recur(cur + 1, cnt)
    selected[cur] = True
    recur(cur + 1, cnt + 1)


answer = 0
selected = [False] * N
recur(0, 0)
print(answer)