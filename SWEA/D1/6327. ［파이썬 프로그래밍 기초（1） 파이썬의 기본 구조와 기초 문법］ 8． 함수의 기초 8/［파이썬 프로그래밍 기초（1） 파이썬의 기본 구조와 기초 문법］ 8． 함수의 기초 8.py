def calc(num):
    print(f"square({num}) => {num * num}")

input = input()
list = input.split(", ")
list = [int(x) for x in list]

calc(list[0])
calc(list[1])

