/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    const hash = {};
    const answer = [];
    let short = null;
    let long = null;
    
    if(nums1.length <= nums2.length) {
        short = nums1;
        long = nums2;
    }
    else {
        short = nums2;
        long = nums1;
    }
    
    
    for(let i = 0; i < short.length; i++) {
         hash[short[i]] = (hash[short[i]] || 0) + 1;
    }
    

    for(let i = 0; i < long.length; i++) {
        if(hash[long[i]] !== undefined && hash[long[i]] > 0) {
            answer.push(long[i]);
            hash[long[i]]--;
        }
    }
    return answer;
};