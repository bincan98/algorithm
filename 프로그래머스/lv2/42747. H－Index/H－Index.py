def solution(citations):
    citations.sort(reverse = True)
    # print(citations)
    if max(citations) == 0:
        return 0
    for i in range(1,max(citations)+1)[::-1]:
        cnt = 0
        for citation in citations:
            if citation >= i:
                cnt += 1
            else:
                break;
        if cnt >= i:
            return i