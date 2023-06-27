import sys

input = lambda: sys.stdin.readline().strip()

lst = []
for _ in range(9):
    lst.append(int(input()))

x = sum(lst) - 100

lst = sorted(lst)

start = 0
end = 8

while True:
    if lst[start] + lst[end] == x:
        break
    elif lst[start] + lst[end] < x:
        start += 1
    else:
        end -= 1

for i in range(9):
    if i != start and i != end:
        print(lst[i])