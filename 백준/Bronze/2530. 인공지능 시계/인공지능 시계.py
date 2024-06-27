"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

A, B, C = map(int, input().split())
D = int(input())

C += D % 60

if C >= 60:
    C = C % 60
    B += 1

D //= 60
B += D % 60
if B >= 60:
    B = B % 60
    A += 1

D //= 60
A += D % 24
if A >= 24:
    A = A % 24

print(A, B, C)