num = input()

print("0 1 2 3 4 5 6 7 8 9")

result = ""

for i in range(10):
    result += str(num.count(str(i)))

    if (i != 9):
        result += " "

print(result)