"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(3):
    start_h, start_m, start_s, end_h, end_m, end_s = map(int, input().split())
    answer_h = end_h - start_h
    answer_m = end_m - start_m
    answer_s = end_s - start_s
    if answer_s < 0:
        answer_s += 60
        answer_m -= 1
    if answer_m < 0:
        answer_m += 60
        answer_h -= 1
    print(answer_h, answer_m, answer_s)