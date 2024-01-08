"""
수학

어떤 수 두개가 같은 간격으로 떨어져있다면 둘이 같은 나머지가 존재한다

따라서 N개의 수를 정렬하고 간격을 모두 구한뒤 간격들의 최소공약수의 1을 제외한 약수가 가능한 M일 것이다
"""
import sys

input = lambda: sys.stdin.readline().strip()


def gcd(a, b):
    if a < b:
        a, b = b, a
    while a % b:
        a, b = b, a % b
    return b


lst = []
for _ in range(int(input())):
    lst.append(int(input()))

lst = sorted(lst)

gap = []
for i in range(len(lst)-1):
    gap.append(lst[i+1] - lst[i])

x = gap[0]
for i in range(1, len(gap)):
    x = gcd(x, gap[i])

divisors = []
for i in range(1, int(x ** 0.5) + 1):
    if x % i == 0:
        divisors.append(i)
        if i * i != x:
            divisors.append(x // i)

divisors = sorted(divisors)
for i in range(1, len(divisors)):
    print(divisors[i], end=" ")