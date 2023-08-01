"""
완전탐색


0부터 1000까지 일하는 라이프 가드 수를 모두 저장하고

소를 하나만 빼보기
(해당 라이프가드 업무시간에 일하는 소가 1이라면 이번 소가 빠지면 0이 된다는 뜻)


"""

import sys

input = lambda: sys.stdin.readline().strip()

time_table = [0] * 1001

N = int(input())

lifeguards = []

for _ in range(N):
    A, B = map(int, input().split())
    lifeguards.append((A, B))
    for i in range(A, B):
        time_table[i] += 1

answer = 0
total = 0

for i in range(1001):
    if time_table[i] > 0:
        total += 1

for i in range(N):
    result = total
    A, B = lifeguards[i]
    for j in range(A, B):
        if time_table[j] == 1:
            result -= 1
    answer = max(answer, result)

print(answer)