score_list = [85, 65, 77, 83, 75, 22, 98, 88, 38, 100]
result = 0

while score_list:
    num = score_list.pop()

    if num >= 80:
        result += num

print(result)