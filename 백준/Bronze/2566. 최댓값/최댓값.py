import sys

input = lambda: sys.stdin.readline().strip()

lst = []
for i in range(9):
    lst.append(list(map(int, input().split())))

r = 0
c = 0
max_value = -1
for i in range(9):
    for j in range(9):
        if lst[i][j] > max_value:
            r = i
            c = j
            max_value = lst[i][j]

print(max_value)
print(r + 1, c + 1)