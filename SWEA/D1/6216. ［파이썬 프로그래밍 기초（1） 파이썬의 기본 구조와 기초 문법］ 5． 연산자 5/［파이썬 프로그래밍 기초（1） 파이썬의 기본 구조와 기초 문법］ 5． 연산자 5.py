water = 100 * 0.8 + 200
salt = 100 * 0.2

print(f'혼합된 소금물의 농도: {round(salt / (water + salt) * 100, 2)}%')