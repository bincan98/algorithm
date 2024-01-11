"""
소인수 분해해서 저장하고 모든 개수가 짝수개라면 DA
하나라도 홀수라면 NE

시간초과

딕셔너리의 값을 0으로 하지 않고 삭제해서 factor for문의 수를 줄임
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

factors = defaultdict(int)
for _ in range(int(input())):
    a = int(input())
    for i in range(2, int(a ** 0.5) + 1):
        while a % i == 0:
            factors[i] += 1
            if factors[i] % 2 == 0:
                del factors[i]
            a //= i
    if a != 1:
        factors[a] += 1
        if factors[a] % 2 == 0:
            del factors[a]
    possible = True
    for factor in factors:
        if factors[factor] % 2 != 0:
            possible = False
            break
    if possible:
        print("DA")
    else:
        print("NE")