import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

answer = 1

for i in range(1, N + 1):
    answer *= i

print(answer)