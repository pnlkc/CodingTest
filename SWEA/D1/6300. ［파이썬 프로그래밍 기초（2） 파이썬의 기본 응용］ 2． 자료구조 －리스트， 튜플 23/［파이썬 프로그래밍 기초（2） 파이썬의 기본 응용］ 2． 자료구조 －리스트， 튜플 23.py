def calc(mL: list):
    temp = []

    for i, num in enumerate(mL):
        if (i % 2 == 1):
            temp.append(num)

    print(temp)

calc([12, 24, 35, 70, 88, 120, 155])