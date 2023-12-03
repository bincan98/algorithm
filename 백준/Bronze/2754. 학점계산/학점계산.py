import sys

input = lambda: sys.stdin.readline().strip()

s = input()

answer = 0.0
if s[0] == 'A':
    answer += 4.0
elif s[0] == 'B':
    answer += 3.0
elif s[0] == 'C':
    answer += 2.0
elif s[0] == 'D':
    answer += 1.0

if s[0] == 'F':
    pass
elif s[1] == '+':
    answer += 0.3
elif s[1] == '-':
    answer -= 0.3

print(answer)