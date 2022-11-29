/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {    
    const answer = [];
    
    for(let i = 0; i < nums.length; i++) {
        let rest = target - nums[i];
        if(nums.includes(rest)) {
            let restIndex = nums.indexOf(rest);
            if(restIndex !== i) {
                answer.push(i);
                answer.push(restIndex);
                break;
            }
        }
    }
    return answer;
};