"""
ZERO   Z
ONE      O
TWO    W
THREE    H
FOUR   U
FIVE     F
SIX    X
SEVEN    S
EIGHT  G
NINE       I
"""
import sys

input = lambda: sys.stdin.readline().strip()


def find(a, char):
    cnt = 0
    for ch in S:
        if ch == char:
            cnt += 1
            answer.append(str(a))
    return cnt


def clear(cnt, num):
    limit = [0] * len(num)
    for j in range(len(num)):
        for i in range(len(S)):
            if S[i] == num[j] and limit[j] < cnt:
                limit[j] += 1
                S[i] = ""


for t in range(int(input())):
    answer = []
    S = list(input())

    cnt_0 = find(0, "Z")
    cnt_2 = find(2, "W")
    cnt_4 = find(4, "U")
    cnt_6 = find(6, "X")
    cnt_8 = find(8, "G")

    clear(cnt_0, ["Z", "E", "R", "O"])
    clear(cnt_2, ["T", "W", "O"])
    clear(cnt_4, ["F", "O", "U", "R"])
    clear(cnt_6, ["S", "I", "X"])
    clear(cnt_8, ["E", "I", "G", "H", "T"])

    cnt_1 = find(1, "O")
    cnt_3 = find(3, "H")
    cnt_5 = find(5, "F")
    cnt_7 = find(7, "S")
    clear(cnt_1, ["O", "N", "E"])
    clear(cnt_3, ["T", "H", "R", "E", "E"])
    clear(cnt_5, ["F", "I", "V", "E"])
    clear(cnt_7, ["S", "E", "V", "E", "N"])

    cnt_9 = find(9, "I")
    answer = sorted(answer)
    result = ''.join(answer)

    print(f'Case #{t + 1}: {result}')