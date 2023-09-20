"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = input()


def recur(cur, string):
    if cur == len(N):
        # print(string)
        global answer
        if string == N:
            answer += 1
        return
    for i in range(10):
        if check[i]:
            s1 = str(i) + string
            s2 = string + str(i)
            if s1 == s2:
                recur(cur + 1, s2)
            else:
                recur(cur + 1, s1)
                recur(cur + 1, s2)


check = [False] * 10
for i in range(len(N)):
    check[int(N[i])] = True

answer = 0
for i in range(10):
    if check[i]:
        recur(1, str(i))

print(answer)