url = input()
protocol = ''
host = ''
others = ''

split = url.split('://')

protocol = split[0]

split = split[1].split('/')

host = split[0]
others = split[1]

print(f'protocol: {protocol}\nhost: {host}\nothers: {others}')