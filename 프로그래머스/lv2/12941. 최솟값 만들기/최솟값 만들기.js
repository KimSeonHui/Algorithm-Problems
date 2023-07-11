function solution(A,B){
    // 1. A, B 정렬하기
    A.sort((a,b) => a-b); // 오름차순 정렬
    B.sort((a,b) => b-a); // 내림차순 정렬
    
    // 2. 두 수 뽑아서 더하기
    let answer = 0;
    for(let i=0; i<A.length; i++) {
        answer += A[i] * B[i];
    }
    return answer;
}