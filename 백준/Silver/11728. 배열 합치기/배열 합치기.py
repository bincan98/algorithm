import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

lst1 = list(map(int, input().split()))
lst2 = list(map(int, input().split()))
lst3 = []

current1 = 0
current2 = 0

lst1isFull = False
lst2isFull = False
while True:
    if current1 == N:
        lst1isFull = True
        break
    elif current2 == M:
        lst2isFull = True
        break

    if lst1[current1] >= lst2[current2]:
        lst3.append(lst2[current2])
        current2 += 1
    else:
        lst3.append(lst1[current1])
        current1 += 1

if lst1isFull:
    lst3 += lst2[current2:]
elif lst2isFull:
    lst3 += lst1[current1:]

print(*lst3)