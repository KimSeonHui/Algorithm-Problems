/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    const hash = {};
    const answer = [];
    
    for(let i = 0; i < nums1.length; i++) {
         hash[nums1[i]] = hash[nums1[i]] + 1 || 1;
    }
    

    for(let i = 0; i < nums2.length; i++) {
        if(hash[nums2[i]] !== undefined && hash[nums2[i]] > 0) {
            answer.push(nums2[i]);
            hash[nums2[i]]--;
        }
    }
    return answer;
};