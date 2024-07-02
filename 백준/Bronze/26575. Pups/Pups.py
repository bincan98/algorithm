"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for i in range(int(input())):
    d, f, p = input().split()
    print(f'${float(d) * float(f) * float(p):.2f}')