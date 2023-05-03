def solution(x, y, n):
    # 상태들이 dag형태로 표현할 수 있어서 dp가 가능
    
    INF = int(1e6)
    
    # x가 dp 테이블의 인덱스를 벗어나지 않는지 체크하는 함수
    def isValid(x):
        return 0<=x<y+1
    
    # i를 만들 수 있는 최소 연산 횟수를 저장할 배열
    dp = [INF] * (y+1)
    
    # 시작지점 초기화
    dp[x] = 0
    
    # x+1 부터 y까지 반복하기
    for i in range(x+1, y+1):
        tmp = INF # tmp 초기화하기
        # i-n이 인덱스안에 있고 방문 했었다면
        if isValid(i-n) and dp[i-n] != INF:
            tmp = min(tmp, dp[i-n]) # tmp에 넣어보기
        # i가 2로 나눌수 있고 i//2이 인덱스안에 있고 방문 했었다면
        if i % 2 == 0 and isValid(i//2) and dp[i//2] != INF:
            tmp = min(tmp, dp[i//2])
        # i가 3로 나눌수 있고 i//3이 인덱스안에 있고 방문 했었다면
        if i % 3 == 0 and isValid(i//3) and dp[i//3] != INF:
            tmp = min(tmp, dp[i//3])
        # 세개 중에 하나라도 만족해서 값이 변했다면
        if tmp != INF:
            # +1 하면서 값 넣어주기
            dp[i] = tmp + 1
        
    # dp[y] 가 방문 했었다면 그대로 방문 안했다면 -1 출력하기
    return -1 if dp[y] == INF else dp[y] 