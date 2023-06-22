"""
누적합 그냥 하면?

1부터 j 까지의 누적합 중 k 인것을 알 수 있다

그리고 1 부터 i 까지의 누적합을 다 빼보면?
N^2로 시간 초과다

딕셔너리를 써서 그전의 누적합을 키로 개수를 값으로 해서 갯수를 체크해두자

이번 누적합 - 지난 누적합 = K 가 되야 하므로 

이번 누적합 - K 가 키인 값을 answer에 더해주자 

이때 defaultdict를 쓰면 키 체크를 하지 않고 편하게 짤 수 있다
"""

import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

lst = [0] + list(map(int, input().split()))

prefix_sum = [0] * (N+1)

# 누적합 만들기
for i in range(1, N+1):
    prefix_sum[i] = prefix_sum[i-1] + lst[i]

# 딕셔너리
int_dict = defaultdict(int)
answer = 0
for i in range(1, N+1):
    # 아무것도 빼지 않고 가능한 경우 체크해보기
    if prefix_sum[i] == K:
        answer += 1
    # (이번 누적합 - K) 가 키인 값 더해주기 (없다면 0을 더한다)
    answer += int_dict[prefix_sum[i] - K]
    # 이번 누적합 딕셔너리에 넣어주기
    int_dict[prefix_sum[i]] += 1

print(answer)