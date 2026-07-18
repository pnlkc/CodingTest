import random

def calc(string: str) -> str:
    result = ''

    for i in range(8):
        result += random.choice(string)

    return result

calc('abcdefghijklmnopqrstuvwxyz01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()?')
print('q3cvr*?K')