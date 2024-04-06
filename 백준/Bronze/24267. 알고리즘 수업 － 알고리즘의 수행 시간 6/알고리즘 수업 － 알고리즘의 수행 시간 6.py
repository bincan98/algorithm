"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

arr = [0] * 500_001

total = 0
for i in range(1, N - 1):
    total += i
    arr[i + 2] = total

print(sum(arr))
print(3)