import sys

input = lambda: sys.stdin.readline().strip()

lst = [0]

index = 0
for i in range(1, 1001):
    if index > 1000:
        break
    for j in range(i):
        lst.append(i)
        index += 1
        if index > 1000:
            break

a, b = map(int, input().split())

answer = 0
for i in range(a, b+1):
    answer += lst[i]

print(answer)