N = int(input())
lst = list(map(int, input().split()))

answer = 0
for ele in lst:
    if ele == 1:
        continue
    cnt = 0
    for i in range(1, int(ele ** 0.5)+1):
        if ele % i == 0:
            cnt += 1
    if cnt == 1:
        answer += 1
print(answer)