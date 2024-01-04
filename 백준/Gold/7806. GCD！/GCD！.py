"""
정수론

n!과 k의 gcd 찾기

gcd는 두 수의 소인수들의 최소개수의 곱

따라서 1부터 n까지 수들과 차례로 k와의 gcd를 구하고 나온 값들을 answer에 곱해두고
동시에 k를 그 값으로 나눠주면서 진행하기

시간초과

뒤에서부터 진행하고 k가 1이되면 그만하기

이래도 시간초과

풀이변경

k를 소인수분해하고
n!에서 소인수의 개수 구하기
k의 소인수개수와 n!의 소인수 개수 중 최소가 최대공약수의 소인수의 개수
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

try:
    while True:
        n, k = map(int, input().split())

        int_dict = defaultdict(int)
        # 소인수 분해하기
        for i in range(2, int(k ** 0.5) + 1):
            while k % i == 0:
                int_dict[i] += 1
                k //= i
        if k != 1:
            int_dict[k] += 1

        answer = 1
        for a in int_dict:
            x = a
            result = 0
            while x <= n:
                result += (n // x)
                x *= a
            answer *= int(a ** min(result, int_dict[a]))

        print(answer)
except:
    exit()