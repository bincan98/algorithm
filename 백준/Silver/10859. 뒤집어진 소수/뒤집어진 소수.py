"""
일단 수 뒤집기

수가 소수인지 체크하기
뒤집힌 수가 소수인지 체크하기

(최적화) 수 중에 3, 4, 7이 있다면 no
"""

# 리스트로 수 입력받기
lst = list(map(int,input()))
# 리스트 합칠 수
N = 0
# 뒤집힌수 저장할 리스트
reverseList = []
# 뒤집힌 수
reverseN = 0

# 리스트 합치기
for i in lst:
    N *= 10
    N += i

# 리스트 조회하면서 수에 3,4,7이 있는지 체크
for i in lst:
    if i in {3, 4, 7}: # 3,4,7이 있다면 no 출력
        print("no")
        break
else:
    # 소수 체크
    cnt = 0
    if N == 1:
        # 1이라면 no 출력
        print("no")
    else:
        # 루트 N 까지 소수 체크하기
        for i in range(1, int(N ** 0.5)+1):
            if N % i == 0:
                cnt += 1
        if cnt != 1:
            print("no")
        else:
            # 소수라면 수 뒤집기
            for i in lst[::-1]: # 반대로
                if i == 6:
                    # 6이라면 9넣기
                    reverseList.append(9)
                elif i == 9:
                    # 9라면 6넣기
                    reverseList.append(6)
                else:
                    reverseList.append(i)
            # 뒤집은 수 합치기
            for i in reverseList:
                reverseN *= 10
                reverseN += i
            # print(reverseN)
            # 소수 체크
            cnt = 0
            for i in range(1, int(reverseN ** 0.5)+1):
                if reverseN % i == 0:
                    cnt += 1
            if cnt == 1:
                print("yes")
            else:
                print("no") 
                