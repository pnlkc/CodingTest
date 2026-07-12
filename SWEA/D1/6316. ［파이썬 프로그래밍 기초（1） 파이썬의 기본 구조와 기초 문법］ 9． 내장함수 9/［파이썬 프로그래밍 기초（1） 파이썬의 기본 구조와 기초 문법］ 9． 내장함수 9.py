def calc(list: list):
    filtered_list = [x * x for x in list if x % 2 == 0]
    print(filtered_list)

list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

calc(list)