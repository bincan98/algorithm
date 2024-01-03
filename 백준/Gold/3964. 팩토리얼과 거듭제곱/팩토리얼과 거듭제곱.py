"""
정수론

n!에 포함된 k의 개수 찾기

k를 소인수 분해한다
그리고 각 소인수가 n!에 몇개나 있는지 체크한다
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()


T = int(input())

for _ in range(T):
    answer = 0
    n, k = map(int, input().split())

    int_dict = defaultdict(int)

    # 소인수 분해하기
    for i in range(2, int(k ** 0.5) + 1):
        while k % i == 0:
            int_dict[i] += 1
            k //= i
    if k != 1:
        int_dict[k] += 1

    # 각 소인수마다 n!에 몇개가 있는지 찾기
    lst = []
    for a in int_dict:
        x = a
        result = 0
        while x <= n:
            result += (n // x)
            x *= a
        # (소인수 개수 // k의 소인수 a의 개수) 연산을 통해 만들 수 있는 개수 찾기
        lst.append(result // int_dict[a])
    # 그 중 최소의 개수가 k의 개수
    print(min(lst))