# 입력 최적화
import sys
input = sys.stdin.readline

N = int(input())
arr = [0] * 1001

start = 1000
end = 0
for i in range(N):
    a, b = map(int, input().split())
    arr[a] = b;
    start = min(start, a);
    end = max(end, a);

leftHigh = [0] * 1001
rightHigh = [0] * 1001

leftMax = 0
for i in range(start, end+1):
    leftMax = max(leftMax, arr[i])
    leftHigh[i] = leftMax

rightMax = 0
for i in range(end, start-1, -1):
    rightMax = max(rightMax, arr[i])
    rightHigh[i] = rightMax

answer = 0
for i in range(start, end+1):
    answer += min(leftHigh[i], rightHigh[i])

print(answer)