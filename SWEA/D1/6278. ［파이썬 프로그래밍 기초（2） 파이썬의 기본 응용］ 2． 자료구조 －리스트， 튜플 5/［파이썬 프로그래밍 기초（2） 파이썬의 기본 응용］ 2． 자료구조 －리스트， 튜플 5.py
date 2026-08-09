num = int(input())
ori_list = [1, 1, 3, 3, 4, 6, 8, 9, 9, 10]
result = [i for i in ori_list if num > i]
print(f'new_list: {result}')