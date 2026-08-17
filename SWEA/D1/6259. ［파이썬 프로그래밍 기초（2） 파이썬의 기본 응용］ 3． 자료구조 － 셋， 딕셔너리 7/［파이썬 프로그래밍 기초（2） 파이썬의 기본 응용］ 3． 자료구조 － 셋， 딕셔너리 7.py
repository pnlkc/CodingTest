m_input = input()

letters = 0
digits = 0

for c in m_input:
  if c.isdigit():
    digits += 1
  elif c.isalpha():
    letters += 1

print(f'LETTERS {letters}')
print(f'DIGITS {digits}')