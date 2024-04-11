"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

answer = False
for i in range(int(input())):
    s = input()
    for j in s:
        if j == 'S':
            print(s)
            answer = True
            break
    if answer:
        break