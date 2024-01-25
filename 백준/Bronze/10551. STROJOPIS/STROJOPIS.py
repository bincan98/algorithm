import sys

input = lambda: sys.stdin.readline().strip()

lst = list(input())

left_5 = ["1", "Q", "A", "Z"]
left_4 = ["2", "W", "S", "X"]
left_3 = ["3", "E", "D", "C"]
left_2 = ["4", "R", "F", "V", "5", "T", "G", "B"]
right_2 = ["6", "Y", "H", "N", "7", "U", "J", "M"]
right_3 = ["8", "I", "K", ","]
right_4 = ["9", "O", "L", "."]
right_5 = ["0", "P", ";", "/", "-", "[", "'", "=", "]"]

answer = [0] * 8

for a in lst:
    if a in left_5:
        answer[0] += 1
    elif a in left_4:
        answer[1] += 1
    elif a in left_3:
        answer[2] += 1
    elif a in left_2:
        answer[3] += 1
    elif a in right_2:
        answer[4] += 1
    elif a in right_3:
        answer[5] += 1
    elif a in right_4:
        answer[6] += 1
    elif a in right_5:
        answer[7] += 1

for a in answer:
    print(a)