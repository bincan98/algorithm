"""
N이 굉장히 크므로 직접 하나하나 나누어 보는건 안될듯

형이 말한 N!에 포함된 소인수 x의 개수를 구하는 법을 써보자

예를 들어 N이 20일때 A가 2라면 저 방법을 쓰면 20!에 몇개의 소인수 2가 포함되어 있는지 알 수 있다

그렇다면 k는 그 개수일 것
"""


N, A = map(int, input().split())

answer = 0
# N!에 포함된 소인수 A의 개수 구하기 기본코드
# N까지 반복할리 없으므로 일단 N 까지로 설정
for i in range(1, N+1):
    # A^i가 N보다 크다면 앞으로는 0일 테니까 나가기
    if int(A ** i) > N:
        break
    answer += N // int(A ** i)


print(answer)