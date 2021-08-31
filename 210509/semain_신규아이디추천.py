def solution(new_id):
    limit_word = '~!@#$%^&*()=+[{]}:?,<>/'
    new_id = new_id.lower()
    
    for w in new_id:
        if w in limit_word:
            new_id = new_id.replace(w, '')
            
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
            
    if new_id[0] == '.' or new_id[-1] == '.':
        new_id = new_id.strip('.')
    
    if not new_id:
        new_id = 'a'
        
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[0] == '.' or new_id[-1] == '.':
            new_id = new_id.strip('.')
            
    if len(new_id) <= 2:
        while len(new_id) < 3:
            new_id += new_id[-1]
    
    return new_id
