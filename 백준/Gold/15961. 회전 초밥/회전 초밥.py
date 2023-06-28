"""
슬라이딩 윈도우 문제이다

한번 돌때마다 배열을 카운트하고 개수를 체크하자
쿠폰번호의 초밥은 자동으로 체크하기

시간복잡도는 O(N)

원 형태는 그만큼 원소를 붙여주는 방법으로 해결
"""


import sys

input = lambda: sys.stdin.readline().strip()

N, d, k, c = map(int, input().split())

lst = []
for _ in range(N):
    lst.append(int(input()))

# 원형의 형태니까 0부터 k-1까지 뒤에 붙여주기
for i in range(0, k):
    lst.append(lst[i])

# check 배열
check = [0] * (d+1)

answer = 0
result = 0
# 첫 슬라이딩 윈도우 배열은 체크하기
for i in range(k):
    if check[lst[i]] == 0:
        result += 1
    check[lst[i]] += 1

# 첫 슬라이딩 윈도우에서 쿠폰번호도 체크
# 범위에 쿠폰 초밥이 없으면 가짓수+1
if check[c] == 0:
    answer = max(answer, result+1)
else:
    answer = max(answer, result)

# 이제 슬라이딩 윈도우로 하나씩 전진하기
for i in range(1, N):
    check[lst[i-1]] -= 1
    if check[lst[i-1]] == 0:
        result -= 1
    if check[lst[i+k-1]] == 0:
        result += 1
    check[lst[i+k-1]] += 1
    if check[c] == 0:
        answer = max(answer, result + 1)
    else:
        answer = max(answer, result)

print(answer)