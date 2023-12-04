"""
배열을 두개씩 합쳐서 투포인터인줄 알았으나 같은 수가 반복되는 경우를 해결하지 못함

이분탐색으로 해결

한 원소의 -1을 곱한 값의 개수를 반대편 배열에서 찾기

찾을떄 upper_bound와 lower_bound 쓰기

target값이 없을 경우 이게 문제가 될 수 있음
answer += upper - lower + 1 부분
따라서 조건 추가
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

A = []
B = []
C = []
D = []

for i in range(n):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB = []
CD = []
for i in range(n):
    for j in range(n):
        AB.append(A[i] + B[j])
        CD.append(C[i] + D[j])

AB = sorted(AB)
CD = sorted(CD)

answer = 0
for i in range(n * n):
    target = -AB[i]
    # lower_bound 찾기
    start = 0
    end = n * n - 1
    lower = n * n
    while start <= end:
        mid = (start + end) // 2
        if CD[mid] >= target:
            end = mid - 1
            lower = mid
        else:
            start = mid + 1
    # upper_bound 찾기
    start = 0
    end = n * n - 1
    upper = n * n
    while start <= end:
        mid = (start + end) // 2
        if CD[mid] <= target:
            start = mid + 1
            upper = mid
        else:
            end = mid - 1
    if upper != n * n:
        answer += upper - lower + 1

print(answer)