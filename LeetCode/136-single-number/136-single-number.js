/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    if(nums.length === 1) return nums[0];
    const hash = {};
    
    nums.sort((a,b) => a-b);
    for(let i = 0; i < nums.length; i++) {
       hash[nums[i]] = (hash[nums[i]] | 0) + 1;
    }

    const result = Object.entries(hash).filter((ele) => ele[1] === 1)
   
    return result[0][0];
};