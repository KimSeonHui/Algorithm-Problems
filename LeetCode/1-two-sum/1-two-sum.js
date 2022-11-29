/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {  
    // 풀이 1
//     const answer = [];
    
//     for(let i = 0; i < nums.length; i++) {
//         let rest = target - nums[i];
//         if(nums.includes(rest)) {
//             let restIndex = nums.indexOf(rest);
//             if(restIndex !== i) {
//                 answer.push(i);
//                 answer.push(restIndex);
//                 break;
//             }
//         }
//     }
//     return answer;
    
    
    //풀이 2
    const hash = {};  
    for(let i = 0; i < nums.length; i++) {
        let cur = nums[i];
        let rest = target-cur;
        if(hash[rest] !== undefined) {
            return [hash[rest], i];
        }
        else {
            hash[cur] = i;
        }
    }
    
};