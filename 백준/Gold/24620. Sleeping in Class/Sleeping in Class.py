"""
N개의 수를 모두 다한것이 total

수열의 모든 수가 같은 수가 되어야 할때 같은 수는 total의 약수만 가능하다

total의 약수들을 후보로 추려서 되는지 확인하기(매개변수 탐색?)

가능한지 아는 방법은 누적합을 만들때 후보수의 범위를 넘어가는지 체크하기
만약 후보수의 범위를 넘어간다면 그 후보수를 두수간의 합으로 만들 수 없는 경우이다 
"""

import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    N = int(input())
    lst = list(map(int, input().split()))

    # total, 누적합 얻기
    total = 0
    for a in lst:
        total += a

    # 전부 0인 경우는 제외
    if total == 0:
        print(0)
        continue

    # 약수 구하기
    measures = []
    for i in range(1, int(total ** 0.5) + 1):
        if total % i == 0:
            measures.append(i)
            if i * i != total:
                measures.append(total // i)

    measures = sorted(measures)

    for measure in measures:
        possible = True
        result = 0
        for a in lst:
            result += a
            if result > measure:
                possible = False
                break
            elif result == measure:
                result = 0
        if possible:
            print(N - total // measure)
            break