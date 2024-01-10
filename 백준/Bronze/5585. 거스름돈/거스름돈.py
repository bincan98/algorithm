import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

N = 1000 - N

coins = [500, 100, 50, 10, 5, 1]
answer = 0

for coin in coins:
    answer += N // coin
    N = N % coin

print(answer)