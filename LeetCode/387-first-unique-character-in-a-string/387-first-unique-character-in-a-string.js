/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    const hash = {};
    
    for(let ch of s) {
        hash[ch] = (hash[ch] || 0) + 1;
    }
    
    for(let ch of s) {
        if(hash[ch] === 1) return s.indexOf(ch);
    }
    
    return -1;
};