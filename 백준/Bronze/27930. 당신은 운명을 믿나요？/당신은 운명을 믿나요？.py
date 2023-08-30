import sys

input = lambda: sys.stdin.readline().strip()

S = input()

YONSEI = [500000] * 6
KOREA = [500000] * 5

cur_y = 0
for i in range(len(S)):
    if cur_y == 0 and S[i] == 'Y':
        YONSEI[cur_y] = i
        cur_y += 1
    elif cur_y == 1 and S[i] == 'O':
        YONSEI[cur_y] = i
        cur_y += 1
    elif cur_y == 2 and S[i] == 'N':
        YONSEI[cur_y] = i
        cur_y += 1
    elif cur_y == 3 and S[i] == 'S':
        YONSEI[cur_y] = i
        cur_y += 1
    elif cur_y == 4 and S[i] == 'E':
        YONSEI[cur_y] = i
        cur_y += 1
    elif cur_y == 5 and S[i] == 'I':
        YONSEI[cur_y] = i
        cur_y += 1
    elif cur_y == 6:
        break

cur_x = 0
for i in range(len(S)):
    if cur_x == 0 and S[i] == 'K':
        KOREA[cur_x] = i
        cur_x += 1
    elif cur_x == 1 and S[i] == 'O':
        KOREA[cur_x] = i
        cur_x += 1
    elif cur_x == 2 and S[i] == 'R':
        KOREA[cur_x] = i
        cur_x += 1
    elif cur_x == 3 and S[i] == 'E':
        KOREA[cur_x] = i
        cur_x += 1
    elif cur_x == 4 and S[i] == 'A':
        KOREA[cur_x] = i
        cur_x += 1
    elif cur_x == 5:
        break

if YONSEI[5] > KOREA[4]:
    print("KOREA")
else:
    print("YONSEI")