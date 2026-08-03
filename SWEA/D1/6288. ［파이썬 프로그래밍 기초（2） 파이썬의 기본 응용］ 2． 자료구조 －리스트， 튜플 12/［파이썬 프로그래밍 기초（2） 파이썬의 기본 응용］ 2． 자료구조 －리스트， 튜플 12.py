result = []

for i in range(1, 21):
    num = i * i

    if i % 3 == 0 and i % 5 == 0:
        continue

    result.append(num)
    
print(result)