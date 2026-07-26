def calc(mL: list):
    temp = [x for x in mL if x % 2 != 0]

    print(temp)

calc([5, 6, 77, 45, 22, 12, 24])