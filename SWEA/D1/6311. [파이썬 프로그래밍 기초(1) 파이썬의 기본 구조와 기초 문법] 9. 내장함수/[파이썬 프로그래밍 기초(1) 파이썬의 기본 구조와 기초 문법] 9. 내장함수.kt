map = {
    'A': 4,
    'B': 3,
    'C': 2,
    'D': 1,
}

def calc(string: str) -> int:
    result = 0

    for c in string:
        result += map[c]

    return result

print(calc('ADCBBBBCABBCBDACBDCAACDDDCAABABDBCBCBDBDBDDABBAAAAAAADADBDBCBDABADCADC'))
