my_tuple = ((90, 80), (85, 75), (90, 100))

for i in range(len(my_tuple)):
    total = sum(my_tuple[i])
    average = total / len(my_tuple[i])

    print(f'{i + 1}번 학생의 총점은 {total}점이고, 평균은 {average:.1f}입니다.')