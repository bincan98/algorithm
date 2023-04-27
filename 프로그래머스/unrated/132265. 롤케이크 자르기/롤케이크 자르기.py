def solution(topping):
    
    chulsoo = [0] * 10001
    bro = [0] * 10001
    
    chulsooKind = 0
    broKind = 0
    
    for top in topping:
        if chulsoo[top] == 0: 
            chulsooKind += 1
        chulsoo[top] += 1

    #print(chulsoo)
    #print(chulsooKind)
    
    answer = 0
    for top in topping:
        chulsoo[top] -= 1
        if chulsoo[top] == 0:
            chulsooKind -= 1
        
        if bro[top] == 0:
            broKind += 1
        bro[top] +=1
        
        if chulsooKind == broKind:
            answer += 1
    
    return answer