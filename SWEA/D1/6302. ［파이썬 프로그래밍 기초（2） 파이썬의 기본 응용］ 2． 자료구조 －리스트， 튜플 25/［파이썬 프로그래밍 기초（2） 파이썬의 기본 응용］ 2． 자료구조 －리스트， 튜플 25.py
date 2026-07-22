def calc(mList):
    remove_idx = [0, 4, 5]
    temp = [v for i, v in enumerate(mList) if i not in remove_idx]

    print(temp)

mList = [12, 24, 35, 70, 88, 120, 155]
calc(mList)