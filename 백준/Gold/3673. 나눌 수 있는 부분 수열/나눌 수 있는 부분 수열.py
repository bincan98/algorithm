"""
수들의 합4와 비슷한 문제

딕셔너리를 써서 (그전의 누적합 % d) 를 키로 개수를 값으로 해서 갯수를 체크해두자

(이번 누적합 - 지난 누적합) % d == 0 가 되야 하므로

이번 누적합 % d 가 키인 값을 answer에 더해주자

이때 defaultdict를 쓰면 키 체크를 하지 않고 편하게 짤 수 있다
"""

import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

c = int(input())

for _ in range(c):
    # 입력받기
    d, n = map(int, input().split())
    lst = [0] + list(map(int, input().split()))

    int_dict = defaultdict(int)
    prefix_sum = [0] * (n+1)

    # 누적합 구하기
    for i in range(1, n+1):
        prefix_sum[i] = prefix_sum[i-1] + lst[i]

    answer = 0
    for i in range(1, n+1):
        # 아무것도 빼지 않고 가능한 경우 체크해보기
        if prefix_sum[i] % d == 0:
            answer += 1
        # 이번 누적합 % d 가 키인 값을 answer에 더해주기
        answer += int_dict[prefix_sum[i] % d]
        # 이번 누적합 % d 가 키인 값을 딕셔너리에 넣어주기
        int_dict[prefix_sum[i] % d] += 1

    print(answer)