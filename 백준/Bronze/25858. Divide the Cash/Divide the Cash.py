import sys

input = lambda: sys.stdin.readline().strip()

n, total = map(int, input().split())

lst = []
for _ in range(n):
    lst.append(int(input()))

sum_value = sum(lst)

for a in lst:
    print(a * total // sum_value)