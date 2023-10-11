"""
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()


def pre_order(cur):
    print(chr(cur + 65), end="")
    if lst[cur][0] != -1:
        pre_order(lst[cur][0])
    if lst[cur][1] != -1:
        pre_order(lst[cur][1])


def in_order(cur):
    if lst[cur][0] != -1:
        in_order(lst[cur][0])
    print(chr(cur + 65), end="")
    if lst[cur][1] != -1:
        in_order(lst[cur][1])


def post_order(cur):
    if lst[cur][0] != -1:
        post_order(lst[cur][0])
    if lst[cur][1] != -1:
        post_order(lst[cur][1])
    print(chr(cur + 65), end="")


N = int(input())
lst = [[-1, -1] for i in range(N + 1)]

for i in range(N):
    a, b, c = input().split()
    if b != '.':
        lst[ord(a) - 65][0] = (ord(b) - 65)
    if c != '.':
        lst[ord(a) - 65][1] = (ord(c) - 65)

pre_order(0)
print()
in_order(0)
print()
post_order(0)