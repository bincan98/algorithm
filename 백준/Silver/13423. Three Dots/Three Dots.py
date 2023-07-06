"""
단순하게 생각하면 순서 상관없이 3개 뽑아서 되느지 확인하기

하지만 1000C3 으로 대강 10억 // 6 으로 너무 크다

두개만 고르고 찾아야하는 하나는 이분탐색으로 구하자
"""

import sys

input = lambda: sys.stdin.readline().strip()

T = int(input())


def binary_search(arr, target):
    start = 0
    end = len(arr) - 1
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return True
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    return False


for i in range(T):
    answer = 0
    N = int(input())
    lst = list(map(int, input().split()))
    lst = sorted(lst)
    for i in range(N):
        for j in range(i+1, N):
            if binary_search(lst, 2 * lst[j] - lst[i]):
                answer += 1
    print(answer)