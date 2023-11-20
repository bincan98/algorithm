"""
냅다 구현
check 배열로 기억하기

9^5 = 약 60,000

그게 4개 
"""

import sys

input = lambda: sys.stdin.readline().strip()

check = [-1] * 240_000

A, P = map(int, input().split())

check[A] = 0

cur = A
cnt = 1
while True:
    total = 0
    for i in range(len(str(cur))):
        total += int(str(cur)[i]) ** P

    if check[total] != -1:
        print(check[total])
        break
    else:
        cur = total
        check[cur] = cnt
    cnt += 1