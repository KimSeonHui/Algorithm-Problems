/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    
    for(let ch of s) {
        const index = t.indexOf(ch);
        if(index !== -1) {
            t = t.slice(0, index) + t.slice(index+1);
        }
        else return false;
    }
    return true;
};