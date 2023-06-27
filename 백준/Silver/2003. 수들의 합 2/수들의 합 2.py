import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
lst = list(map(int, input().split()))

start = 0
end = 0

answer = 0
result = lst[0]
while True:
    if result == M:
        answer += 1
        end += 1
        if end == N:
            break
        result += lst[end]
    elif result < M:
        end += 1
        if end == N:
            break
        result += lst[end]
    else:
        result -= lst[start]
        start += 1

print(answer)