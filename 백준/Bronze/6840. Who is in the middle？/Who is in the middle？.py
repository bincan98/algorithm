import sys

input = lambda: sys.stdin.readline().strip()

lst = []

for i in range(3):
    lst.append(int(input()))

lst = sorted(lst)

print(lst[1])