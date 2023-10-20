import sys
import math

input = lambda: sys.stdin.readline().strip()

s = input()

for i in range(math.ceil(len(s) / 10)):
    print(s[i * 10 : i * 10 + 10])