T = int(input().strip())

for tc in range(0, T):
    line = input().split(' ')

    n = int(line[0])
    str = line[1]
    
    result = []
    for char in str:
        result.append(f"{int(char, 16):04b}")
    
    print(f"#{tc + 1} {''.join(result)}")