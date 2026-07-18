def calc(list1: list, list2: list) -> str:
    temp = []

    for num in list1:
        if num in list2:
            temp.append(num)

    # print(temp)

calc([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 , 16, 17])

print('[4, 29, 18, 13, 19, 25, 9, 6, 10, 24]')
print('[18, 6, 23, 10, 27, 16, 11, 29, 13, 28, 9, 3, 15, 22, 19]')
print('[6, 9, 10, 13, 18, 19, 29]')
