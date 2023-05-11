def solution(cap, n, deliveries, pickups):
    deliverieEnd = n - 1
    pickupsEnd = n - 1

    while deliverieEnd != -1 and deliveries[deliverieEnd] == 0:
        deliverieEnd -= 1

    while pickupsEnd != -1 and pickups[pickupsEnd] == 0:
        pickupsEnd -= 1

    # print(deliverieEnd, pickupsEnd)

    answer = 0
    while True:
        if deliverieEnd == -1 and pickupsEnd == -1:
            break

        maxValue = 0
        if deliverieEnd != -1:
            maxValue = max(maxValue, deliverieEnd + 1)
        if pickupsEnd != -1:
            maxValue = max(maxValue, pickupsEnd + 1)
        answer += 2 * maxValue

        for i in range(cap):

            if deliverieEnd != -1:
                deliveries[deliverieEnd] -= 1

            while deliverieEnd != -1 and deliveries[deliverieEnd] == 0:
                deliverieEnd -= 1

            if pickupsEnd != -1:
                pickups[pickupsEnd] -= 1

            while pickupsEnd != -1 and pickups[pickupsEnd] == 0:
                pickupsEnd -= 1

    # print(deliverieEnd, pickupsEnd)
    return answer