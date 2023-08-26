"""
백트로 풀자

1넣기
2넣기
3넣기

그리고 항상 좋은수열인지 체크해서 아니라면 return 시키자
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

answer = 0
# for i in range(n):
#     answer *= 10
#     answer += 3


def check_not_good_sequence(arr):
    for i in range(2, len(arr)+1, 2): # 이번에 볼 부분수열 길이
        for j in range(len(arr)): # 부분수열 시작 지점
            if i + j > len(arr):
                break
            # print(arr[j:j+i//2])
            # print(arr[j+i//2:j+i])
            if arr[j:j+i//2] != arr[j+i//2:j+i]:
                continue
            else:
                return True
    return False


def recur(arr):
    global answer
    if answer != 0:
        return
    if check_not_good_sequence(arr):
        return
    if len(arr) == n:
        # arr 합치고 min에 넣기
        result = 0
        for i in arr:
            result *= 10
            result += i
        # answer = min(answer, result)
        answer = result
        return
    recur(arr + [1])
    recur(arr + [2])
    recur(arr + [3])


recur([])
print(answer)