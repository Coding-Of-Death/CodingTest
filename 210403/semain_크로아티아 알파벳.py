croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()
for cro in croatia:
    if cro in word:
        word = word.replace(cro, ' ')
print(len(word))
