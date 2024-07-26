while 1:
    data = input()
    if data == '# 0 0':
        break

    data = data.split()

    if int(data[1]) > 17 or int(data[2]) >= 80:
        print(data[0], 'Senior')
    else:
        print(data[0], 'Junior')
