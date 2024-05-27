"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = "WelcomeToSMUPC"

N = int(input())

print(lst[N % 14 - 1])