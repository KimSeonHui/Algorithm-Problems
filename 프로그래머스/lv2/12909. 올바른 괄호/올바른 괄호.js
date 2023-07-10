function solution(s){
    let answer = true;
    
    const stack = [];
    for(let i=0; i<s.length; i++) {
        if(s[i] === '(') stack.push('(');
        else {
            if(stack.length > 0) stack.pop();
            else answer = false;
        }
    }
    
    if(stack.length > 0) answer = false;
    return answer;
}