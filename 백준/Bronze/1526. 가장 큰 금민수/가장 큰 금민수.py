import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(4, N+1)[::-1]:
    can = i
    possible = True
    while can != 0:
        if can % 10 != 4 and can % 10 != 7:
            possible = False
            break
        can //= 10
    if possible:
        print(i)
        break