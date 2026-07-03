def check(num: int, list: list):
        print(f"{num} => {'True' if num in list else 'False'}")

list = [2, 4, 6, 8, 10]

print(list)
check(5, list)
check(10, list)