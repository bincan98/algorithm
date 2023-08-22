"""
완전탐색

그냥 시계에서 가능한 시간을 0부터 시작하면 될듯?

broken이 #고 number가 #라면 이 수는 가능
broken이 #고 number가 .라면 이 수는 불가능
broken이 .고 number가 #라면 이 수는 가능
broken이 .고 number가 .라면 이 수는 가능
"""
import sys

input = lambda: sys.stdin.readline().strip()

number = [["###",
           "#.#",
           "#.#",
           "#.#",
           "###"],
          ["..#",
           "..#",
           "..#",
           "..#",
           "..#"],
          ["###",
           "..#",
           "###",
           "#..",
           "###"],
          ["###",
           "..#",
           "###",
           "..#",
           "###"],
          ["#.#",
           "#.#",
           "###",
           "..#",
           "..#"],
          ["###",
           "#..",
           "###",
           "..#",
           "###"],
          ["###",
           "#..",
           "###",
           "#.#",
           "###"],
          ["###",
           "..#",
           "..#",
           "..#",
           "..#"],
          ["###",
           "#.#",
           "###",
           "#.#",
           "###"],
          ["###",
           "#.#",
           "###",
           "..#",
           "###"]]

h1 = []
h2 = []
m1 = []
m2 = []

for i in range(5):
    a, b, c, d = input().split()
    h1.append(a)
    h2.append(b)
    m1.append(c)
    m2.append(d)

broken = []
broken.append(h1)
broken.append(h2)
broken.append(m1)
broken.append(m2)

selected = []
for i in range(4):
    for j in range(10):
        nxtNumber = False
        for k in range(5):
            for l in range(3):
                if broken[i][k][l] == '#' and number[j][k][l] == '.':
                    nxtNumber = True
                    break
            if nxtNumber:
                break
        if nxtNumber:
            continue
        else:
            selected.append(j)
            break

print(selected[0], selected[1], ":", selected[2], selected[3], sep="")