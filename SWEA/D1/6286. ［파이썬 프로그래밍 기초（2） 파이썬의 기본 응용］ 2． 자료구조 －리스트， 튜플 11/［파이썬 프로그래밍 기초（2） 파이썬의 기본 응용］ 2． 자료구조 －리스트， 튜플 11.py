result = [1, 1]

while len(result) < 10:
    last = len(result) - 1

    result.append(result[last - 1] + result[last])

print(result)