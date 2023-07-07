function solution(s) {
    const split = s.toLowerCase().split('');
    
    split[0] = split[0].toUpperCase();
    let isWhiteSpace = false;
    const answer = [];
    for(let str of split) {
        str = isWhiteSpace ? str.toUpperCase() : str;
        isWhiteSpace = str == ' ' ? true : false;
        answer.push(str);
    }
    
    return answer.join('');
}