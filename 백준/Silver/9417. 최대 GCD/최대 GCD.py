"""
모든 두수의 쌍이므로 조합

M이 100이하이므로 최대 100C2이므로 4950

N이 100이므로 495,000

gcd 구하기는 거의 상수 시간이라했으니까 완전탐색 가능할듯
"""

N = int(input())


# 최대공약수 구하는 기본코드 
def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


for testCase in range(N):
    # 리스트 입력받기
    lst = list(map(int, input().split()))
    # 최대 공약수중 가장 큰값이므로 가장 작은 수로 초기화
    answer = -(2 ** 32)

    # 두개 구하는 조합이므로 for문 두개로
    for i in range(len(lst)):
        for j in range(i + 1, len(lst)):
            # gcd 구해서 answer에 넣어보기 
            answer = max(answer, gcd(max(lst[i], lst[j]), min(lst[i], lst[j])))

    print(answer)