def calc(*args: int):
    print(f"max({', '.join(str(x) for x in args)}) => {max(args)}")

calc(3, 5, 4, 1, 8, 10, 2)