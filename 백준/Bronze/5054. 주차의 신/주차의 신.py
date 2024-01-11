import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    n = int(input())
    lst = list(map(int, input().split()))

    print((max(lst) - min(lst)) * 2)