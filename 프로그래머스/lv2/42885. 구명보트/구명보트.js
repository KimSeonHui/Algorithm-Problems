function solution(people, limit) {
    let answer = 0;
    
    const map = {};
    for(let i=0; i<people.length; i++) {
        map[people[i]] = limit - people[i];
    }
    
    people.sort((a,b) => a-b);
    
    let small = 0; let large = people.length-1;
    while(small <= large) {
        if(map[people[large]] >= people[small]) {
            large--;
            small++;
        }
        else {
            large--;
        }
        answer++;
    }
    return answer;
}