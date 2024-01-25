import sys

input = lambda: sys.stdin.readline().strip()

D, M = map(int, input().split())

answer = ["Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"]
month_days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

days = D
for i in range(M):
    days += month_days[i]

days %= 7

print(answer[days])