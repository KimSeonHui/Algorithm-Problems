function solution(n) {
    let answer = 0;
    for(let i=n+1; i<=1000000; i++) {
        if(getCount(n.toString(2)) === getCount(i.toString(2))) {
            answer = i;
            break;
        }
    }
    return answer;
}


function getCount(num) {
    let cnt = 0;
    for(let i=0; i<num.length; i++) {
        if(num[i] === '1') cnt++;
    }
    return cnt;
}
