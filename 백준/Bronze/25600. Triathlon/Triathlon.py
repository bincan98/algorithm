N = int(input())
answer = 0
for _ in range(N):
    a, d, g = map(int, input().split())
    result = a * (d + g)
    if a == d + g:
        result *= 2
    answer = max(answer, result)

print(answer)