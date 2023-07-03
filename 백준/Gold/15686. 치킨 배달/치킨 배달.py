"""
조합과 구현

"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

ch_house = []
house = []

for i in range(N):
    lst = list(map(int, input().split()))
    for j in range(N):
        if lst[j] == 1:
            house.append([[i, j], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
        elif lst[j] == 2:
            ch_house.append([i, j])

for ch in range(len(ch_house)):
    for h in range(len(house)):
        house[h][ch+1] = abs(ch_house[ch][0] - house[h][0][0]) + abs(ch_house[ch][1] - house[h][0][1])

numbers = [-1] * M

def combi(index, current):
    if index == M:
        global answer
        result = 0
        for h in house:
            minValue = 100
            for num in numbers:
                minValue = min(minValue, h[num+1])
            result += minValue
        answer = min(answer, result)
        return
    for i in range(current, len(ch_house)):
        numbers[index] = i
        combi(index + 1, i + 1)

answer = 10000
combi(0, 0)

print(answer)