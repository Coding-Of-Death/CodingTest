def solution(s):
    answer = s
    temp = ""
    
    alph = {"zero":"0", "one":"1", "two":"2", "three":"3", "four":"4",
            "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}
    
    for a in alph:
        answer = answer.replace(a, alph[a])
        
    return int(answer)
