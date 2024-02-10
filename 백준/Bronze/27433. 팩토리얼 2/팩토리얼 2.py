import sys

input = lambda: sys.stdin.readline().strip()

lst = [1] * 21

for i in range(1, 21):
    lst[i] = lst[i-1] * i

print(lst[int(input())])