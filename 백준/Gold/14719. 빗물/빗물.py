import sys
input = sys.stdin.readline

H, W = map(int, input().split())
lst = [0] + list(map(int, input().split())) + [0] # 양 끝에 0더해주기

# 왼쪽 최대값 저장할 배열
prefix_max = [0] * (W+2)
# 오른쪽 최대값 저장할 배열
suffix_max = [0] * (W+2)

# 왼쪽부터 돌면서 최대값을 저장하기
for i in range(1, W+1):
    prefix_max[i] = max(prefix_max[i-1], lst[i])

# 오른쪽부터 돌면서 최대값을 저장하기
for i in range(W, 0, -1):
    suffix_max[i] = max(suffix_max[i+1], lst[i])

answer = 0
# 왼쪽부터 돌면서
for i in range(W):
    # 물이고이는양 = (왼쪽, 오른쪽 최대값 중 최솟값 - 원래의 블록) 을 answer에 더해주기 
   answer += min(prefix_max[i], suffix_max[i]) - lst[i]

print(answer)