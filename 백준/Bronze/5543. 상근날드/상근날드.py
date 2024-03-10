"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

burger = 2000
for _ in range(3):
    burger = min(burger, int(input()))
drink = 2000
for _ in range(2):
    drink = min(drink, int(input()))

print(burger + drink - 50)