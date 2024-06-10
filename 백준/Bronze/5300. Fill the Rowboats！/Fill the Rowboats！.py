"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

a = int(input())

for i in range(1, a + 1):
    print(i, end=" ")
    if i % 6 == 0:
        print("Go!", end=" ")

if a % 6 != 0:
    print("Go! ")