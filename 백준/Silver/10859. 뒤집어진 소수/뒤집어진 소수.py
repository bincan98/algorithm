"""
일단 수 뒤집기

뒤집힌 수가 소수인지 체크하기

(최적화) 수 중에 3, 4, 7이 있다면 no
"""

lst = list(map(int,input()))
N = 0
reverseList = []
reverseN = 0

for i in lst:
    N *= 10
    N += i

for i in lst:
    if i in {3, 4, 7}:
        print("no")
        break
else:
    cnt = 0
    if N == 1:
        print("no")
    else:
        for i in range(1, int(N ** 0.5)+1):
            if N % i == 0:
                cnt += 1
        if cnt != 1:
            print("no")
        else:
            for i in lst[::-1]:
                if i == 6:
                    reverseList.append(9)
                elif i == 9:
                    reverseList.append(6)
                else:
                    reverseList.append(i)
            for i in reverseList:
                reverseN *= 10
                reverseN += i
            # print(reverseN)
            cnt = 0
            if reverseN == 1:
                print("no")
            else:
                for i in range(1, int(reverseN ** 0.5)+1):
                    if reverseN % i == 0:
                        cnt += 1
                if cnt == 1:
                    print("yes")
                else:
                    print("no")