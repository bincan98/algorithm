"""
조합으로 줄여볼수도 있겠지만 나이브하게 순열로 풀어보자

"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

oper_num = list(map(int, input().split()))

operator = []
for i in range(4):
    for j in range(oper_num[i]):
        if i == 0:
            operator.append('+')
        elif i == 1:
            operator.append('-')
        elif i == 2:
            operator.append('*')
        else:
            operator.append('//')
# 입력 완료

maxValue = -1_000_000_000
minValue = 1_000_000_000

operator_perm = [-1] * (N-1)
isSelected = [False] * (N-1)


def caculate(a, b ,oper):
    if oper == '+':
        return a + b
    elif oper == '-':
        return  a - b
    elif oper == '*':
        return a * b
    else:
        if a < 0:
            return -(-a // b)
        else:
            return a // b


def perm(index):
    if index == N-1:

        global maxValue
        global minValue

        prefix_ele = lst[0]

        for i in range(N-1):
            suffix_ele = lst[i+1]
            prefix_ele = caculate(prefix_ele, suffix_ele, operator[operator_perm[i]])

        maxValue = max(maxValue, prefix_ele)
        minValue = min(minValue, prefix_ele)

        return
    for i in range(N-1):
        if isSelected[i]:
            continue
        operator_perm[index] = i
        isSelected[i] = True
        perm(index + 1)
        isSelected[i] = False

perm(0)

print(maxValue)
print(minValue)