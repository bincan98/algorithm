"""
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

T = int(input())

for i in range(T):
    input()
    N, M = map(int, input().split())
    sejun = deque(sorted(list(map(int, input().split()))))
    sebi = deque(sorted(list(map(int, input().split()))))

    # sejun = sorted(sejun)
    # sebi = sorted(sebi)

    sejun_pointer = 0
    sebi_pointer = 0

    while sebi and sejun:
        if sejun[0] < sebi[0]:
            sejun.popleft()
        else:
            sebi.popleft()

    if sejun:
        print("S")
    else:
        print("B")