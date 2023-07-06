"""
완전탐색으로 3개 뽑아서 만나면 시간이 터진다

두개만 뽑고 하나는 이분 탐색으로 찾자

가장 작은 벌점이 목표인데 뭘 찾지

첫번째 수와 두번째 수의 범위 안에 있는 수를 찾자

반례) 범위 안의 수가 없다면???
45
46
1 2 78 79

수는 계속 줄어드니까 answer에 계속 넣어보자

만약 수의 범위 안에 있다면 그만두기

만약 둘 중 작은 수보다 작으면 위를 탐색하기

만약 둘 중 큰 수보다 크면 아래를 탐색하기
"""

import sys

input = lambda: sys.stdin.readline().strip()

A, B, C = map(int, input().split())

lst_A = list(map(int, input().split()))
lst_B = list(map(int, input().split()))
lst_C = list(map(int, input().split()))

lst_C = sorted(lst_C)

answer = 200_000_000


def binary_search(lst, a, b):
    result = 200_000_000
    start = 0
    end = len(lst) - 1
    while start <= end:
        mid = (start + end) // 2
        if lst[mid] < b:
            result = min(result, abs(a - lst[mid]))
            start = mid + 1
        elif a < lst[mid]:
            result = min(result, abs(lst[mid] - b))
            end = mid - 1
        else:
            return a - b
    return result


for a in lst_A:
    for b in lst_B:
        answer = min(answer, binary_search(lst_C, max(a, b), min(a, b)))

print(answer)