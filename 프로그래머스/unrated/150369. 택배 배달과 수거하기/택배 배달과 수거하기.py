def solution(cap, n, deliveries, pickups):
    # 각각 deliveries와 pickups의 인덱스를 나타낼 변수
    deliverieEnd = n - 1
    pickupsEnd = n - 1

    # 값이 0이 아닌 끝인덱스를 찾기
    while deliverieEnd != -1 and deliveries[deliverieEnd] == 0:
        deliverieEnd -= 1

    while pickupsEnd != -1 and pickups[pickupsEnd] == 0:
        pickupsEnd -= 1

    #최소 이동거리를 저장할 변수
    answer = 0
    while True:
        # 인덱스가 -1이 될때까지 반복하기, -1이면 그 배열은 전부 봤다는 뜻
        if deliverieEnd == -1 and pickupsEnd == -1:
            break

        # 양 배열의 인덱스중 가장 먼걸 찾기 위해 사용한 변수
        maxValue = 0
        if deliverieEnd != -1: # 배열이 아직 남았다면
            maxValue = max(maxValue, deliverieEnd + 1)
        if pickupsEnd != -1: # 배열이 아직 남았다면
            maxValue = max(maxValue, pickupsEnd + 1)
        # 물류창고에서 가장 먼거리까지 다녀온것이므로 2를 곱해서 더해주기
        answer += 2 * maxValue 

        # cap만큼 반복하기
        for i in range(cap):
            # 이미 인덱스는 값이 있는곳에 멈췄으니 바로 1을 빼기
            if deliverieEnd != -1:
                deliveries[deliverieEnd] -= 1

            # 다음 0이 아닌 값을 가지고 있는 인덱스를 찾기
            while deliverieEnd != -1 and deliveries[deliverieEnd] == 0:
                deliverieEnd -= 1

            # 31줄과 같음
            if pickupsEnd != -1:
                pickups[pickupsEnd] -= 1

            # 35줄과 같음
            while pickupsEnd != -1 and pickups[pickupsEnd] == 0:
                pickupsEnd -= 1

    return answer