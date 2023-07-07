function solution(s) {
    const split = s.toLowerCase().split('');
    
    split[0] = split[0].toUpperCase();
    let isWhiteSpace = false;
    for(let i=1; i<split.length; i++) {
        split[i] = isWhiteSpace ? split[i].toUpperCase() : split[i];
        isWhiteSpace = split[i] == ' ' ? true : false;
    }
    return split.join('');
}