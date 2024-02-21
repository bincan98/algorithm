
"""
관찰

8로 나눴을때 나머지 따라 다름
1 : 1
2,0 : 2
3,7 : 3
4,6 : 4
5 : 5
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

answer = 0
if n % 8 == 0:
    n = 2
elif n % 8 == 7:
    n = 3
elif n % 8 == 6:
    n = 4

print(n % 8)