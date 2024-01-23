"""
일단 3개의 자연수로 분해해야 하니까 3이 몇개 있는지 구한다

그리고 그 개수를 어떻게 분배할지 고르기

예를 들어 15라면 기본적으로 3 3 3 을 분배하고 남은 3 두개를 어떻게 분배할지 고르기

중복조합
nHr = n + r - 1 C r

9 3 3
6 6 3
6 3 6
3 9 3
3 6 6
3 3 9
"""
import sys
import math

input = lambda: sys.stdin.readline().strip()

n = int(input())

if n < 9:
    print(0)
    exit()

print(math.comb(3 + (n // 3 - 3) - 1, (n // 3 - 3)))