"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = []
result = 0
for _ in range(3):
    lst.append(int(input()))

if max(lst) == 60 and min(lst) == 60:
    print("Equilateral")
elif sum(lst) == 180 and (lst[0] == lst[1] or lst[1] == lst[2] or lst[2] == lst[0]):
    print("Isosceles")
elif sum(lst) == 180 and (lst[0] != lst[1] and lst[1] != lst[2]):
    print("Scalene")
elif sum(lst) != 180:
    print("Error")
