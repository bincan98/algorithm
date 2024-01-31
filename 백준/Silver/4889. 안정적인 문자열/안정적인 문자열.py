"""
일단 스택을 이용해서 가능한 안정적인 문자열 처리하기

남은 괄호의 개수를 이용해서 최소연산의 개수구하기
열거나 닫는 괄호끼리 두개씩은 연산 하나로 처리할 수 있다.
그리고 남은 개수가 각각 하나라면 두번의 연산으로 처리한다
"""
import sys

input = lambda: sys.stdin.readline().strip()

i = 0
while True:
    s = list(input())
    i += 1
    if s[0] == "-":
        break
    lst = []
    cnt_open = 0
    cnt_close = 0
    for a in s:
        if a == "{":
            lst.append(a)
            cnt_open += 1
        else:
            cnt_close += 1
            if len(lst) != 0:
                lst.pop()
                cnt_open -= 1
                cnt_close -= 1
    cnt = 0
    cnt += cnt_open // 2
    cnt_open %= 2
    cnt += cnt_close // 2
    cnt_close %= 2
    if cnt_open == 1 and cnt_close == 1:
        cnt += 2
    print(f'{i}. {cnt}')