"""
Hoof 는 가위를 이긴다

가위는 보를 이긴다

보는 hoof를 이긴다

비기기도 가능

모든 경우를 하면 오래걸릴듯

H, 보, 가위 3개만 내면서 몇번 이길 수 있는지
prefix_win_sum 과 suffix_win_sum 으로 누적해두자
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = ['start']

for i in range(1, N+1):
    lst.append(input())

# 앞부터 누적승 저장할 배열 (양쪽에 패딩 주기)
prefix_win_sum_H = [0] * (N+2)
prefix_win_sum_S = [0] * (N+2)
prefix_win_sum_P = [0] * (N+2)

# 뒤부터 누적승 저장할 배열
suffix_win_sum_H = [0] * (N+2)
suffix_win_sum_S = [0] * (N+2)
suffix_win_sum_P = [0] * (N+2)

# 앞부터 누적승 구하기
for i in range(1, N+1):
    prefix_win_sum_H[i] = prefix_win_sum_H[i-1]
    prefix_win_sum_S[i] = prefix_win_sum_S[i-1]
    prefix_win_sum_P[i] = prefix_win_sum_P[i-1]
    if lst[i] == 'H':
        prefix_win_sum_P[i] += 1
    elif lst[i] == 'P':
        prefix_win_sum_S[i] += 1
    else:
        prefix_win_sum_H[i] += 1

# 뒤부터 누적승 구하기
for i in range(1, N+1)[::-1]:
    suffix_win_sum_H[i] = suffix_win_sum_H[i+1]
    suffix_win_sum_S[i] = suffix_win_sum_S[i+1]
    suffix_win_sum_P[i] = suffix_win_sum_P[i+1]
    if lst[i] == 'H':
        suffix_win_sum_P[i] += 1
    elif lst[i] == 'P':
        suffix_win_sum_S[i] += 1
    else:
        suffix_win_sum_H[i] += 1


maxValue = 0
# 제스처를 한번도 바꾸지 않고 내는 경우 
maxValue = max(maxValue, prefix_win_sum_P[N])
maxValue = max(maxValue, prefix_win_sum_S[N])
maxValue = max(maxValue, prefix_win_sum_H[N])
for i in range(1, N+1):
    # 보를 내다가 바꾸는 경우
    maxValue = max(maxValue, prefix_win_sum_P[i] + suffix_win_sum_S[i+1])
    maxValue = max(maxValue, prefix_win_sum_P[i] + suffix_win_sum_H[i+1])
    # 가위를 내다가 바꾸는 경우
    maxValue = max(maxValue, prefix_win_sum_S[i] + suffix_win_sum_P[i+1])
    maxValue = max(maxValue, prefix_win_sum_S[i] + suffix_win_sum_H[i+1])
    # Hoof를 내다가 바꾸는 경우
    maxValue = max(maxValue, prefix_win_sum_H[i] + suffix_win_sum_P[i+1])
    maxValue = max(maxValue, prefix_win_sum_H[i] + suffix_win_sum_S[i+1])

print(maxValue)