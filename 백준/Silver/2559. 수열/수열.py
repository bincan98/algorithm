# 입력 최적화
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = [0] + list(map(int, input().split()))

# 처음 수열 합 구하기
sum = 0
for i in range(K+1):
    sum += arr[i]
answer = sum

# 하나씩 밀면서 가기
for i in range(1, N-K+1):
    sum -= arr[i]
    sum += arr[i+K]
    # answer에 넣어보기
    answer = max(answer, sum)

print(answer)