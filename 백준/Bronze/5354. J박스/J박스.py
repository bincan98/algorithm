"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

T = int(input())

for _ in range(T):
    a = int(input())
    for i in range(a):
        if i == 0 or i == a - 1:
            for _ in range(a):
                print("#", end="")
            print()
        else:
            for j in range(a):
                if j == 0 or j == a - 1:
                    print("#", end="")
                else:
                    print("J", end="")
            print()
    print()