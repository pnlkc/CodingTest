numbers = [x for x in range(1, 11)]
result = list(filter(lambda x: x % 2 == 0, numbers))
print(result)