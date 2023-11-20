import sys

input = lambda: sys.stdin.readline().strip()

check = [False] * 1_000_001
N = int(input())
lst = []

for i in range(N):
    a = int(input())
    lst.append(a)
    check[a] = True

answer = 1
for i in range(1_000_001):
    if not check[i]:
        continue
    cnt = 1
    prev = 0
    for j in range(len(lst)):
        if lst[j] != i:
            prev = j
            break

    for j in range(prev + 1, len(lst)):
        if lst[j] == i:
            continue
        if lst[prev] == lst[j]:
            cnt += 1
            answer = max(answer, cnt)
        else:
            cnt = 1
        prev = j

print(answer)