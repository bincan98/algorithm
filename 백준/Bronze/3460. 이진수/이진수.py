import sys

input = lambda: sys.stdin.readline().strip()


T = int(input())

for i in range(T):
    n = int(input())

    i = 0
    while n > 0:
        if n % 2 == 1:
            print(i, end=" ")
        i += 1
        n //= 2