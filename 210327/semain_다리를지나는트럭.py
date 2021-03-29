def solution(bridge_length, weight, truck_weights):
    queue = [0] * bridge_length
    count = 0
    while queue:
        count += 1
        queue.pop(0)
        if truck_weights:
            if sum(queue) + truck_weights[0] <= weight:
                queue.append(truck_weights.pop(0))
            else:
                queue.append(0)
    return count
