/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const hash = {};
    
    for(let num of nums) {
        hash[num] = (hash[num] | 0) + 1;
        
        if(hash[num] > Math.floor(nums.length / 2)) return num;
    }
};