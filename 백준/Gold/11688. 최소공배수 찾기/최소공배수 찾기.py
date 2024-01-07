"""
a와 b를 이용해 최소공배수(lcm)를 구하고
만약 L보다 크거나 L이 LCM의 배수가 아니라면 불가능한 경우

lcm과 L의 소인수를 구하고
둘을 비교하면서 최소의 c 만들기

만약 L에 있는데 lcm에 없는 소인수라면 그만큼 answer에 곱하기
만약 둘 다 있다면 L만큼 포함하기
결국 L만틈 answer에 곱하는셈
둘의 개수가 같을 경우만 넘어가기
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


def factorization(x):
    lst = defaultdict(int)
    for i in range(2, int(x ** 0.5) + 1):
        while x % i == 0:
            lst[i] += 1
            x //= i
    if x != 1:
        lst[x] += 1
    return lst


a, b, L = map(int, input().split())

if a < b:
    a, b = b, a
lcm = a * b // gcd(a, b)

if lcm > L or L % lcm != 0:
    print(-1)
    exit()

L_factor = factorization(L)
lcm_factor = factorization(lcm)

answer = 1
for a in L_factor:
    if lcm_factor[a] == L_factor[a]:
        continue
    answer *= int(a ** L_factor[a])

print(answer)