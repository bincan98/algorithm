"""
완탐
어떤 좌표가 주어지면 거기서 가능성이 있는 y 좌표들
그럼 후보는 y좌표 100개를 중복 조합으로 뽑기 5050

그리고 그 안의 좌표가 N//2개를 못넘으면 다음으로 넘어가고

넘는다면 모든 경우마다 사각형의 넓이 구해보기
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

lst = []
for _ in range(n):
    lst.append(list(map(int, input().split())))

lst = sorted(lst)
answer = 100_000_000
for i in range(n):
    for j in range(i, n):
        can = []
        for y, x in lst:
            if lst[i][0] <= y <= lst[j][0]:
                can.append(x)
        if len(can) < n / 2:
            continue
        can = sorted(can)
        for k in range(int(len(can) - n / 2) + 1):
            answer = min(answer, (abs(lst[i][0] - lst[j][0]) + 2) * (can[k + n // 2 - 1] - can[k] + 2))

print(answer)