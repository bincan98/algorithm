def solution(citations):
    # 큰수 부터 정렬
    citations.sort(reverse = True)
    
    # 만약 배열이 0으로만 이루어져 있다면 H가 0보다 클 수 없으므로 그냥 0 리턴
    if max(citations) == 0:
        return 0
    
    # 가능한 H의 최대부터 1까지 반복하기
    for i in range(1,max(citations)+1)[::-1]:
        cnt = 0 # i번 이상 인용된 논문이 몇편인지 셀 변수
        # 논문 반복하기
        for citation in citations:
            if citation >= i: # i번 이상 인용된 논문이라면
                cnt += 1 # 카운트 하기
            else: # 아니라면
                break; # 더이상 볼 필요 없으므로 break
        # 한번의 i가 끝나면 조건 체크
        if cnt >= i: # i번 이상 인용된 논문의 개수가 i보다 크다면
            return i # 바로 리턴하기