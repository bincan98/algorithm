"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

A, B, C, D = map(int, input().split())
P, M, N = map(int, input().split())

for a in [P, M, N]:
    result = 0
    cur = 0
    i = 0
    while True:
        if i % 2 == 0:
            cur += A
        else:
            cur += B
        if a <= cur:
            if i % 2 == 0:
                result += 1
            break
        i += 1
    cur = 0
    i = 0
    while True:
        if i % 2 == 0:
            cur += C
        else:
            cur += D
        if a <= cur:
            if i % 2 == 0:
                result += 1
            break
        i += 1
    print(result)