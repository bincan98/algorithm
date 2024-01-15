"""
분자와 분모의 소인수를 모아두는 딕셔너리를 만들어둔다

각 수를 소인수를 분해해서 딕셔너리에 넣을때 상대방의 소인수가 있는지 체크하고 있다면 수를 줄여준다

시간초과
수를 만들면서 나머지로 나누어주기
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

numerator = defaultdict(int)
denominator = defaultdict(int)

for _ in range(int(input())):
    A, B = map(int, input().split())
    A = B - A
    for i in range(2, int(A ** 0.5) + 1):
        while A % i == 0:
            if denominator[i]:
                denominator[i] -= 1
            else:
                numerator[i] += 1
            A //= i
    if A != 1:
        if denominator[A]:
            denominator[A] -= 1
        else:
            numerator[A] += 1

    for i in range(2, int(B ** 0.5) + 1):
        while B % i == 0:
            if numerator[i]:
                numerator[i] -= 1
            else:
                denominator[i] += 1
            B //= i
    if B != 1:
        if numerator[B]:
            numerator[B] -= 1
        else:
            denominator[B] += 1

answer_A = 1
answer_B = 1
for a in numerator:
    answer_A *= int(a ** numerator[a])
    answer_A %= 1_000_000_007
for b in denominator:
    answer_B *= int(b ** denominator[b])
    answer_B %= 1_000_000_007

print(answer_A, answer_B)