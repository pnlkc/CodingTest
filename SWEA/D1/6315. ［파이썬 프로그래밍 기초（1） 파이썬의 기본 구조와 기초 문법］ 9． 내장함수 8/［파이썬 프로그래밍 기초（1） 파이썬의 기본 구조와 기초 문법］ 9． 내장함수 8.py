def calc(list: list):
    temp = [x * x for x in list]

    print(temp)

list = [x for x in range(1, 11)]
calc(list)