"""
imos 써보기
"""

import sys

input = sys.stdin.readline

N, H = map(int, input().split())

# 양 옆에 패딩 주기
imo = [0] * (H + 2)

for i in range(N):
    h = int(input())
    # 짝수인지 홀수인지 따라서 imos 다르게 표시
    if i % 2 == 0:
        imo[1] += 1
        imo[h+1] += -1
    else:
        imo[H-h+1] += 1
        imo[H+1] += -1

# 행으로 누적합 해주기
for i in range(1, H+2):
    imo[i] += imo[i-1]

# 패딩 빼기 (패딩은 0이므로)
imo = imo[1:H+1]
# 원하는 값 구하기
minValue = min(imo)
cnt = 0
for i in imo:
    if minValue == i:
       cnt += 1

print(f'{minValue} {cnt}')