import sys

input = lambda: sys.stdin.readline().strip()

answer = []
for _ in range(2):
    T, F, S, A1, A2 = map(int, input().split())
    answer.append(6 * T + 3 * F + 2 * S + 1 * A1 + 2 * A2)

print(*answer)