lst = [0] * 46

lst[1] = 1

for i in range(2, 46):
    lst[i] = lst[i-1] + lst[i-2]

print(lst[int(input())])
