/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const hash = {};
    
    for(let num of nums) {
        hash[num] = (hash[num] | 0) + 1;
    }
    
    const result = Object.entries(hash).find((ele) => ele[1] > Math.floor(nums.length/2));    
    return result[0];
};