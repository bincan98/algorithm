"""
전체 거리 구하고

점 하나 정하면

그 앞뒤 거리 빼고 그 둘 사이의 거리를 더해서 answer에 넣어두기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

x = []
y = []

for i in range(N):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

total = 0
for i in range(N-1):
    total += abs(x[i] - x[i+1]) + abs(y[i] - y[i+1])

answer = total
for i in range(1, N-1):
    result = total
    result -= abs(x[i - 1] - x[i]) + abs(y[i - 1] - y[i])
    result -= abs(x[i] - x[i + 1]) + abs(y[i] - y[i + 1])
    result += abs(x[i - 1] - x[i + 1]) + abs(y[i - 1] - y[i + 1])
    answer = min(answer, result)

print(answer)