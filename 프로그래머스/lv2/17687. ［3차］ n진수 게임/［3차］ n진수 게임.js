function solution(n, t, m, p) {
    let nums = '';
    for(let i=0; i<=t*m; i++) {
        nums += i.toString(n);
    }
    
    let answer = '';
    for(let i=0; i<nums.length; i++) {
        if(i%m === (p-1)) answer += nums[i];
        if(answer.length === t) break;
    }
    
    return answer.toUpperCase();
}