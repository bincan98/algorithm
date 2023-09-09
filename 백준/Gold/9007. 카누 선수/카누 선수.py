"""
60 52 80 40
75 68 88 63

135 128 148 123 ...     백만

48 93 48 54
56 73 49 75

 ... 백만

ls1의 오른쪽 끝
ls2의 왼쪽 끝에서 다가오면서
조건을 만족하는 두 수 찾기
"""
import sys

input = lambda: sys.stdin.readline().strip()

T = int(input())
for _ in range(T):
    ls = []
    k, n = map(int, input().split())
    for _ in range(4):
        ls.append(list(map(int, input().split())))

    ls1 = []
    ls2 = []

    for i in range(n):
        for j in range(n):
            ls1.append(ls[0][i] + ls[1][j])

    for i in range(n):
        for j in range(n):
            ls2.append(ls[2][i] + ls[3][j])

    ls1 = sorted(ls1)
    ls2 = sorted(ls2)

    # print(ls1)
    # print(ls2)

    ls1_pointer = len(ls1) - 1
    ls2_pointer = 0

    answer = ls1[len(ls1) - 1] + ls2[len(ls2) - 1]
    while ls1_pointer != -1 and ls2_pointer != len(ls2):
        sum_value = ls1[ls1_pointer] + ls2[ls2_pointer]
        # print(ls1[ls1_pointer], ls2[ls2_pointer], sum_value)
        if abs(sum_value - k) < abs(answer - k):
            answer = sum_value
        elif abs(sum_value - k) == abs(answer - k) and sum_value - k < answer - k:
            answer = sum_value
        if sum_value < k:
            ls2_pointer += 1
        elif sum_value > k:
            ls1_pointer -= 1
        else:
            answer = k
            break
    print(answer)