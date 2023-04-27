def solution(topping):
    
    chulsoo = [0] * 10001 # 철수 토핑 배열
    bro = [0] * 10001 # 동생 토핑 배열
    
    chulsooKind = 0 # 철수 토핑 종류
    broKind = 0 # 동생 토핑 종류
    
    # 철수한테 다 주기
    for top in topping:
        if chulsoo[top] == 0: # 새로 추가된 토핑이라면
            chulsooKind += 1 # 종류 1 추가하기
        chulsoo[top] += 1 # 토핑 배열에 넣기
    
    answer = 0 # 공평하게 자르는 방법 수
    # 하나씩 동생한테 주기
    for top in topping:
        # 철수꺼 하나 뺏기
        chulsoo[top] -= 1
        if chulsoo[top] == 0: # 뺏어서 없어졌다면
            chulsooKind -= 1 # 종류 줄이기
        
        # 동생에 추가해주기
        if bro[top] == 0: # 동생 배열에 새로 추가되는 거라면
            broKind += 1 # 종류 추가하기
        bro[top] +=1 # 토핑 배열에 넣기
        
        # 공평하게 나눴다면(둘의 토핑 종류가 같다면)
        if chulsooKind == broKind:
            answer += 1 # answer 추가하기
    
    return answer