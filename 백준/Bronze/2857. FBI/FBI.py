import sys

input = lambda: sys.stdin.readline().strip()

answer = []
for i in range(5):
    s = input()
    if "FBI" in s:
        answer.append(i + 1)

if len(answer) == 0:
    print("HE GOT AWAY!")
else:
    print(*answer)