/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    
    s = s.split('').sort();
    t = t.split('').sort();
    
    if(s.toString() === t.toString()) return true;
    else return false;
};