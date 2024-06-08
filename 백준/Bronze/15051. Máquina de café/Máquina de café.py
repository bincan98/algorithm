"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = []

for i in range(3):
    lst.append(int(input()))

answer = 987654321

answer = min(answer, lst[1] * 2 + lst[2] * 4)
answer = min(answer, lst[0] * 2 + lst[2] * 2)
answer = min(answer, lst[0] * 4 + lst[1] * 2)

print(answer)