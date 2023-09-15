

N, M = map(int, input().split())

arr = [i for i in map(int, input().split())]

ans = 0
i, j = 0, 0
total = arr[0]
while True:
    if total == M:
        ans += 1
        total -= arr[i]
        i += 1
    elif total < M:
        j += 1
        if j >= N:
            break
        total += arr[j]
    else:
        total -= arr[i]
        i += 1

print(ans)