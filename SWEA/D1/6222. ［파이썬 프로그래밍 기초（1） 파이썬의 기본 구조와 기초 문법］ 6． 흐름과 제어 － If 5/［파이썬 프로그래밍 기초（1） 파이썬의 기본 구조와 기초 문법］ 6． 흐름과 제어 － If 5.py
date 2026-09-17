m_input = input()

if m_input.isalpha():
  if m_input.isupper():
    lower = m_input.lower()
    print(f'{m_input}(ASCII: {ord(m_input)}) => {lower}(ASCII: {ord(lower)})')
  else:
    upper = m_input.upper()
    print(f'{m_input}(ASCII: {ord(m_input)}) => {upper}(ASCII: {ord(upper)})')
else:
  print(m_input)