import sys

input = lambda: sys.stdin.readline().strip()

yd = input()
yd_L = 0
yd_O = 0
yd_V = 0
yd_E = 0
for i in range(len(yd)):
    if yd[i] == 'L':
        yd_L += 1
    elif yd[i] == 'O':
        yd_O += 1
    elif yd[i] == 'E':
        yd_E += 1
    elif yd[i] == 'V':
        yd_V += 1
name = []
n = int(input())
for i in range(n):
    name.append(input())

name = sorted(name)

answer = ''
proba = -1
for i in range(n):
    L = yd_L
    O = yd_O
    V = yd_V
    E = yd_E
    for j in range(len(name[i])):
        if name[i][j] == 'L':
            L += 1
        elif name[i][j] == 'O':
            O += 1
        elif name[i][j] == 'E':
            E += 1
        elif name[i][j] == 'V':
            V += 1
    proba_can = ((L + O) * (L+V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100
    if proba < proba_can:
        proba = proba_can
        answer = name[i]

print(answer)