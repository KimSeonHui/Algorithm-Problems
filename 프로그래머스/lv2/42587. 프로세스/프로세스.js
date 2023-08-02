function solution(priorities, location) {
    var answer = 0;
    let list = priorities.map((val, i) => ({location : i ,  priority : val,}));
    let isTargetPrinted = false;
    
    while(!isTargetPrinted) {
        let j = list.shift();
        let hasHighPriority = list.some((ele) => ele.priority > j.priority);

        if(hasHighPriority) {
            list.push(j); 
        }
        else {
            answer++;
            isTargetPrinted = (j.location === location) ? true : false;
        }
    }   
    
    return answer;
}