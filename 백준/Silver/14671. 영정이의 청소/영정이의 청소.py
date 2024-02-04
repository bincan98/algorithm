"""
첫날과 둘쨋날 같은 위치에 곰팡이가 있다면 그건 영원히 증식할 곰팡이이다.
그리고 거기서부터 곰팡이가 무한 증식할 수 있다
따라서 영원히 증식할 곰팡이를 찾고 최대한 멀리 퍼뜨려보기

틀림

https://sumin-kim-dev.github.io/boj/boj-silver-14671/

곰팡이는 어차피 퍼져나간다
초기위치의 홀짝이 중요함
(홀 홀) (홀 짝) (짝 홀) (짝 짝)
이 모두 채워지면 언젠가는 집을 모두 채울것
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, M, K = map(int, input().split())

result = [[False for _ in range(2)] for _ in range(2)]
for _ in range(K):
    x, y = map(int, input().split())
    result[x % 2][y % 2] = True

if False in result[0] or False in result[1]:
    print("NO")
else:
    print("YES")