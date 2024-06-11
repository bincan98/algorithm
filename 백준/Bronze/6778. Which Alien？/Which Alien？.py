"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

antena = int(input())
eye = int(input())

if 3 <= antena and eye <= 4:
    print("TroyMartian")
if antena <= 6 and 2 <= eye:
    print("VladSaturnian")
if antena <= 2 and eye <= 3:
    print("GraemeMercurian")