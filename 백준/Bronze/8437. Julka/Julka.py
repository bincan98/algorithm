import sys

input = lambda: sys.stdin.readline().strip()

a = int(input())
b = int(input())
print((a + b) // 2)
print(a - (a + b) // 2)