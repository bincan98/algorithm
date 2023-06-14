"""
왜인지는 모름

그냥 다 써보니까 제곱수만 백색임
"""

N = int(input())


answer = 0


for i in range(1, int(N ** 0.5)+1):
    answer += 1


print(answer)
