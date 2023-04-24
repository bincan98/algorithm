# 입력 최적화
import sys
input = sys.stdin.readline

N = int(input())
# 기둥저장할 배열
arr = [0] * 1001

# 다각형 시작과 끝 찾기위한 변수
start = 1000
end = 0
for i in range(N):
    a, b = map(int, input().split())
    arr[a] = b; # 배열 저장
    start = min(start, a);
    end = max(end, a);

# 왼쪽에서 높은 기둥 저장
leftHigh = [0] * 1001
# 오른쪽에서 높은 기둥 저장
rightHigh = [0] * 1001

leftMax = 0
for i in range(start, end+1):
    leftMax = max(leftMax, arr[i])
    leftHigh[i] = leftMax # 왼쪽에서 가장 큰 기둥 배열에 넣기

rightMax = 0
for i in range(end, start-1, -1):
    rightMax = max(rightMax, arr[i])
    rightHigh[i] = rightMax # 오른쪽에서 가장 큰 기둥 배열에 넣기

answer = 0
for i in range(start, end+1):
    answer += min(leftHigh[i], rightHigh[i]) # answer에 둘 중 낮은 기둥 넣기

print(answer)