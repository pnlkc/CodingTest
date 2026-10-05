T = int(input())

for tc in range(0, T):
    input_list = input().strip().split(' ')
    n = int(input_list[0])
    m = int(input_list[1])
    num_list = list(map(int, input().strip().split(' ')))
    presum = [0]

    for i in range(0, n):
        presum.append(presum[i] + num_list[i])

    min_sum = 1000000
    max_sum = 0

    for i in range(m, n + 1):
        result = presum[i] - presum[i - m]
        min_sum = min(min_sum, result)
        max_sum = max(max_sum, result)

    print(f'#{tc + 1} {max_sum - min_sum}')