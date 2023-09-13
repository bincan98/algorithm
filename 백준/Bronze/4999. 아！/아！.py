import sys

input = lambda: sys.stdin.readline().strip()

s1 = input()
s2 = input()

if len(s1) >= len(s2):
    print("go")
else:
    print("no")