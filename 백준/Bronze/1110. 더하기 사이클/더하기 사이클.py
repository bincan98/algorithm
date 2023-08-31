import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

if N < 10:
    N *= 10

new_N = N
cycle = 0
while True:
    new_N = (new_N % 10 * 10) + (new_N % 10 + new_N // 10) % 10
    cycle += 1
    if new_N == N:
        break

print(cycle)