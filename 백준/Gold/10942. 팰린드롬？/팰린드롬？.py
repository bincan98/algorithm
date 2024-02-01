"""
쿼리 문제

N은 2000

미리 팰린드롬인지 검사하고 저장해두기

홀수 팰린드롬과 짝수 팰린드롬을 나눠서 검사하기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

arr = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    arr[i][i] = 1
    l = i
    r = i
    for j in range(1, N):
        l -= 1
        r += 1
        if l < 0 or r >= N:
            break
        if lst[l] == lst[r]:
            arr[l][r] = 1
        else:
            break

for i in range(N-1):
    if lst[i] != lst[i+1]:
        continue
    arr[i][i+1] = 1
    l = i
    r = i + 1
    for j in range(1, N):
        l -= 1
        r += 1
        if l < 0 or r >= N:
            break
        if lst[l] == lst[r]:
            arr[l][r] = 1
        else:
            break

for _ in range(int(input())):
    S, E = map(int, input().split())
    print(arr[S-1][E-1])
