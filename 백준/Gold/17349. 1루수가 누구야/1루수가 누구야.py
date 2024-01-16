"""
선수는 9명 뿐이니까 한명의 말을 빼고 듣는 경우를 모두 계산해도 81번이다

완탐으로 접근

틀림

https://www.acmicpc.net/board/view/40342
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = [[-1, -1]]
for i in range(9):
    lst.append(list(map(int, input().split())))

answer = []
for i in range(1, 10): # 거짓말 하는 사람
    who = [-1] * 10
    contradiction = False
    for j in range(1, 10): # 증언 살피기
        if i == j: # 거짓 증언 살피기
            for a in range(1, 10):
                if a == j:
                    continue
                if lst[j] == lst[a]:
                    contradiction = True
                    break
            if contradiction:
                break
            if lst[j][0] == 1:
                who[lst[j][1]] = 0
            else:
                # 같은 사람을 제외하고 이미 1루수로 지목된 사람이 있다면 모순
                for k in range(1, 10):
                    if who[k] == 1:
                        if lst[j][1] == k:  # 같은 사람이라면 넘어가기
                            continue
                        else:
                            contradiction = True
                            break
                if contradiction:
                    break
                who[lst[j][1]] = 1
            continue
        # 참 증언 살피기
        # 1루수라는 증언인 경우
        if lst[j][0] == 1:
            # 같은 사람을 제외하고 이미 1루수로 지목된 사람이 있다면 모순
            for k in range(1, 10):
                if who[k] == 1:
                    if lst[j][1] == k: # 같은 사람이라면 넘어가기
                        continue
                    else:
                        contradiction = True
                        break
            if contradiction:
                break
            # 이미 1루수가 아니라는 증언이 나왔는데 대치된다면
            if who[lst[j][1]] == 0:
                contradiction = True
                break
            else:
                who[lst[j][1]] = 1
        else: # 1루수가 아니라는 증언의 경우
            if who[lst[j][1]] == 1:
                contradiction = True
                break
            else:
                who[lst[j][1]] = 0
    # 모순이 없는 경우
    if not contradiction:
        # 만약 1루수로 지목된 사람이 없는 경우
        if max(who) == 0:
            # -1인 사람이 1루수가 될 가능성이 있는 사람
            for k in range(1, 10):
                if who[k] == -1:
                    answer.append(k)
        # 1루수로 지목된 사람암 있다면 그사람이 정답
        else:
            for k in range(1, 10):
                if who[k] == 1:
                    answer.append(k)

# answer에 중복 제거
answer = list(set(answer))
# answer에 답이 없거나 여러개라면 -1 출력
if len(answer) == 1:
    print(*answer)
else:
    print(-1)