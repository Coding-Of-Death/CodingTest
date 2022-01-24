from collections import defaultdict

def solution(id_list, report, k):
    answer = []

    report_cnt = defaultdict(list)

    for r in report:
        id, reports = r.split()
        if not reports in report_cnt:
            report_cnt[reports] += [[id], 1]
        else:
            if id not in report_cnt[reports][0]:
                report_cnt[reports][0].append(id)
                report_cnt[reports][1] += 1

    for i in id_list:
        cnt = 0
        for reported, li in report_cnt.items():
            if li[1] >= k and i in li[0]:
                cnt += 1
        answer.append(cnt)
    return answer
  
  
  
  # 간단한 방법
  
def solution(id_list, report, k):
    answer = [0] * len(id_list)
    reports = {x : 0 for x in id_list}

    # 중복 방지로 set
    for r in set(report):
        reports[r.split()[1]] += 1

    for r in set(report):
        if reports[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1

    return answer
