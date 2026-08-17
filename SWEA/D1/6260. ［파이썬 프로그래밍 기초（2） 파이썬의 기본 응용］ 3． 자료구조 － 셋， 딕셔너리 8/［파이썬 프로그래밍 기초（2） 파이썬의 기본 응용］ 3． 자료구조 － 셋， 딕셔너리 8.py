m_input = input()

print(f'UPPER CASE {len([c for c in m_input if c.isupper()])}')
print(f'LOWER CASE {len([c for c in m_input if c.islower()])}')