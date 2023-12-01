import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(N // 4):
    print("long ", end="")
print("int")