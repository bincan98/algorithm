import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

int_dict = defaultdict(int)
N = int(input())
for i in list(map(int, input().split())):
    int_dict[i] += 1

M = int(input())
for i in list(map(int, input().split())):
    if int_dict[i]:
        print(1)
    else:
        print(0)