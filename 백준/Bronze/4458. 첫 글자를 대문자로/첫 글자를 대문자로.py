import sys

input = lambda: sys.stdin.readline().strip()


n = int(input())

for i in range(n):
    s = input()
    print(s[0].upper() + s[1:len(s)+1])