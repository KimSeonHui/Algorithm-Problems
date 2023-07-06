function solution(s) {
    const split = s.split(' ');
    
    const nums = [];
    for(let num of split) {
        nums.push(Number(num));
    }
    nums.sort((a,b) => a-b);
    
    const answer = `${nums[0]} ${nums[nums.length-1]}`;
    return answer;
}