n, k = map(int, input().split())
arr = list(map(int, input().split()))

num_arr = [0 for i in range(200001)]
length = 0
left = 0
right = 0

num_arr[arr[right]] += 1

while True:

    if num_arr[arr[right]] > k:
        num_arr[arr[left]] -= 1
        left += 1
    else:
        length = max(length, right - left + 1)
        right += 1
        if right == n:
            break
        num_arr[arr[right]] += 1


print(length)