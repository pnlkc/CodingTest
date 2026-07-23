def makeArr(a: int, b: int, c: int) -> list:
    list = [[[0 for _ in range(c)] for _ in range(b)] for _ in range(a)]

    return list


print(makeArr(2, 3, 4))