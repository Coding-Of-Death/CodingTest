def solution(genres, plays):
    answer = []
    
    dic = {}
    total_dic = {}
    
    for i in range(len(genres)):
        if genres[i] not in dic.keys():
            dic[genres[i]] = [(plays[i], i)]
            total_dic[genres[i]] = plays[i]
        else:
            dic[genres[i]].append((plays[i], i))
            total_dic[genres[i]] += plays[i]
    
    sorted_total = sorted(total_dic.items(), key=lambda x:x[1], reverse=True)

    for key in sorted_total:
        album_list = dic[key[0]]
        album_list = sorted(album_list, key=lambda x:(-x[0], x[1]))
        
        for i in range(len(album_list)):
            if i == 2:
                break
            answer.append(album_list[i][1])
    
    return answer
