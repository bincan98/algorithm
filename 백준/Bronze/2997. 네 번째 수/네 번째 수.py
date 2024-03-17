lst = list(map(int, input().split()))

lst = sorted(lst)

if lst[1] - lst[0] == lst[2] - lst[1]:
    print(lst[2] * 2 - lst[1])
elif lst[1] - lst[0] > lst[2] - lst[1]:
    print(lst[0] + lst[2] - lst[1])
else:
    print(lst[1] * 2 - lst[0])