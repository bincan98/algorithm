import sys

input = lambda: sys.stdin.readline().strip()

A, B, V = map(int, input().split())

real_distance = V - A

answer = 1
if real_distance % (A - B) == 0:
    answer += real_distance // (A - B)
else:
    answer += real_distance // (A - B) + 1

print(answer)