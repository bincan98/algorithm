"""
완전 탐색 먼저

1부터 999_999까지 돌아가면서 나머지가 무엇인지 찾기
그리고 겹치면 다음 수로 넘어가기

최악의 경우에는?

1_000_000 * (300)

3억
"""

import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N = int(input())

for _ in range(N):
    G = int(input())
    lst = []
    # 수 입력받기
    for _ in range(G):
        lst.append(int(input()))
    # 수를 1부터 999_999 까지 모두 탐색하기
    for i in range(1, 1_000_000):
        # 나머지를 저장할 배열
        remain = []
        isNext = False
        for ele in lst:
            if ele % i in remain:
                isNext = True
                break
            else:
                remain.append(ele % i)
        if isNext:
            continue
        else:
            print(i)
            break