N = int(input())
for i in range(N):
    a, b, x = map(int, input().split())
    print(a * (x - 1) + b)