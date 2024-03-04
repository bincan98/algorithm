"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

i = 666
result = 0


def is_valid(i):
    repeat = 0
    while i:
        if i % 10 == 6:
            repeat += 1
            if repeat == 3:
                return True
        else:
            repeat = 0
        i //= 10
    return False


while True:
    if is_valid(i):
        result += 1
    if result == N:
        break
    i += 1

print(i)