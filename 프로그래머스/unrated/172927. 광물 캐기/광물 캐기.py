import sys

sys.setrecursionlimit(10 ** 6)

ls = []
minValue = 987654


def solution(picks, minerals):
    global ls, minValue
    ls = minerals
    recur(0, picks[0], picks[1], picks[2], 0, "", -1)
    return minValue


def recur(depth, dia, iron, stone, pirodo, pick, cnt):
    global ls, minValue

    if depth == len(ls):
        minValue = min(minValue, pirodo)
        return
    
    if dia + iron + stone == 0 and cnt == 5:
        minValue = min(minValue, pirodo)
        return

    # 새로 뽑음
    if cnt == -1 or cnt == 5:
        if dia > 0:
            recur(depth, dia - 1, iron, stone, pirodo, "dia", 0)

        if iron > 0:
            if ls[depth] == "diamond":
                recur(depth, dia, iron-1, stone, pirodo, "iron", 0)
            else:
                recur(depth, dia, iron-1, stone, pirodo, "iron", 0)

        if stone > 0:
            if ls[depth] == "diamond":
                recur(depth, dia, iron, stone - 1, pirodo, "stone", 0)
            elif ls[depth] == "iron":
                recur(depth, dia, iron, stone - 1, pirodo, "stone", 0)
            else:
                recur(depth, dia, iron, stone - 1, pirodo, "stone", 0)

    # 새로 뽑지 않음
    else:
        if pick == "dia":
            recur(depth + 1, dia, iron, stone, pirodo + 1, pick, cnt + 1)

        elif pick == "iron":
            if ls[depth] == "diamond":
                recur(depth + 1, dia, iron, stone, pirodo + 5, pick, cnt + 1)
            else:
                recur(depth + 1, dia, iron, stone, pirodo + 1, pick, cnt + 1)

        else:
            if ls[depth] == "diamond":
                recur(depth + 1, dia, iron, stone, pirodo + 25, pick, cnt + 1)
            elif ls[depth] == "iron":
                recur(depth + 1, dia, iron, stone, pirodo + 5, pick, cnt + 1)
            else:
                recur(depth + 1, dia, iron, stone, pirodo + 1, pick, cnt + 1)