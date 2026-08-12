str = 'Python is powerful... and fast; plays well with others; runs everywhere; is friendly & easy to learn; is Open.'
vowel = ['a', 'e', 'i', 'o', 'u']
temp = [i for i in str if i not in vowel]

print(''.join(temp))
