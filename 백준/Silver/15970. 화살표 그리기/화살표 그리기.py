"""
완전탐색

모든 점을 받을 수 있느 ㄴ공간 만들고 받기

근데 나중에 범위 조정 안하려면 -1넣고 시작해서 -1 넣고 끝내기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

arr = [[-1] for _ in range(N + 1)]

for i in range(N):
    x, y = map(int, input().split())
    arr[y].append(x)

for i in range(N + 1):
    arr[i] = sorted(arr[i])
    arr[i].append(-1)

answer = 0
for i in range(N + 1):
    for ele in range(len(arr[i])):
        if arr[i][ele] == -1:
            continue
        if arr[i][ele-1] == -1:
            answer += arr[i][ele+1] - arr[i][ele]
        elif arr[i][ele+1] == -1:
            answer += arr[i][ele] - arr[i][ele-1]
        else:
            answer += min(arr[i][ele+1] - arr[i][ele], arr[i][ele] - arr[i][ele-1])

print(answer)