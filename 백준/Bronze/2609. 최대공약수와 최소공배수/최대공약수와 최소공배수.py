"""
"""

import sys

input = sys.stdin.readline

A, B = map(int, input().split())


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


GCD = gcd(max(A, B), min(A, B))


print(GCD, A * B // GCD)