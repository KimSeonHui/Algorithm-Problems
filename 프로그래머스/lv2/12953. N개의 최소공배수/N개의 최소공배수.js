function solution(arr) {
    if(arr.length < 2) return arr[0];
    
    // 최소 공배수 구하기 >> 두 수의 곱 / 최대 공약수
    let answer = arr[0] * arr[1] / gcd(arr[0], arr[1]);
    if(arr.length > 2) {
        for(let i=2; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
    }
    return answer;
}

// 최대 공약수 구하기
function gcd(a, b) {
    if(a > b) {
        const c = a % b;
        if(c === 0) return b;
        else return gcd(b, c);
    }
    else {
        const c = b % a;
        if(c === 0) return a;
        else return gcd(a, c);
    }
}