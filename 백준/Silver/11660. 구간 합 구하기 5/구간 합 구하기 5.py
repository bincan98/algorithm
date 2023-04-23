import sys

input = sys.stdin.readline

N, M = map(int, input().split())

arr = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    lst = list(map(int, input().split()))
    for j in range(N):
        if j == 0:
            arr[i][j] = lst[j]
        else:
            arr[i][j] = arr[i][j-1] + lst[j]

arr2 = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    for j in range(N):
        if i == 0:
            arr2[i][j] = arr[i][j]
        else:
            arr2[i][j] = arr2[i-1][j] + arr[i][j]

for _ in range(M):
    y1, x1, y2, x2 = map(int, input().split())
    if x1 == 1 and y1 == 1:
        print(arr2[y2-1][x2-1])
    elif x1 == 1:
        print(arr2[y2-1][x2-1] - arr2[y1-2][x2-1])
    elif y1 == 1:
        print(arr2[y2-1][x2-1] - arr2[y2-1][x1-2])
    else:
        print(arr2[y2-1][x2-1] - arr2[y2-1][x1-2] - arr2[y1-2][x2-1] + arr2[y1-2][x1-2])