score_list = [88, 30, 61, 55, 95]

for i in range(0, len(score_list)):
    score = score_list[i]

    if score >= 60:
        print(f'{i + 1}번 학생은 {score}점으로 합격입니다.')
    else:
        print(f'{i + 1}번 학생은 {score}점으로 불합격입니다.')