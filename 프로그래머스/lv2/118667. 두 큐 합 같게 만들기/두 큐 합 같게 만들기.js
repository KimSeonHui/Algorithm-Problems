function solution(queue1, queue2) {
    let total = 0;  // 두 큐에 담긴 모든 원소의 합
    let sum1 = 0;
    let sum2 = 0;
    let isAnswer = false;
        
    for(let i=0; i<queue1.length; i++) {
        sum1 += queue1[i];
        sum2 += queue2[i];
    }
    
    total = sum1 + sum2;
    if(total % 2 != 0) return -1;
    
    let start1 = 0; // queue1의 front 포인터
    let start2 = 0; // queue2의 front 포인터
    let tried = 0, queueLength = queue1.length + queue2.length; 
    while(tried < queueLength * 2) {
        if(sum2 < sum1) {
            let num = queue1[start1++];
            sum1 -= num;
            
            queue2.push(num);
            sum2 += num;
        }
        else if(sum1 < sum2) {
            let num = queue2[start2++];
            sum2 -= num;
            
            queue1.push(num);
            sum1 += num;
        }
        else {
            isAnswer = true;
            break;
        }
        tried++;
    }
    return isAnswer ? tried : -1;
}
