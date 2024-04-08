"""
관찰
순서대로 탐색
처음엔 스택에 무조건 넣기
그리고 스택의 마지막 원소와 비교하기
새 원소가 크거나 같다면 그 앞에 원소는 버리고 다시 비교하기
작다면 스택의 길이만큼 answer에 넣기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
stk = []
answer = 0
for _ in range(N):
    x = int(input())
    while stk:
        if stk[-1] <= x:
            stk.pop()
        else:
            answer += len(stk)
            stk.append(x)
            break
    if not stk:
        stk.append(x)
print(answer)