"""
LIS

dp접근법은 시간초과다
시간복잡도가 O(NlogN)인 이분탐색 써주기

https://velog.io/@ledcost/%EB%B0%B1%EC%A4%80-12015-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4-2-%EA%B3%A8%EB%93%9C2-%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89

틀림

https://www.acmicpc.net/board/view/76907
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))
lis = [lst[0]]


def binary_search(x):
    start = 0
    end = len(lis) - 1
    find = -1
    while start <= end:
        mid = (start + end) // 2
        if lis[mid] == x:
            return mid
        elif lis[mid] < x:
            start = mid + 1
        else:
            find = mid
            end = mid - 1
    return find


for i in range(N):
    if lis[-1] < lst[i]:
        lis.append(lst[i])
    else:
        idx = binary_search(lst[i])
        lis[idx] = lst[i]

print(len(lis))